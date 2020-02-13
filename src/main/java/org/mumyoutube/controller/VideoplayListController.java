package org.mumyoutube.controller;


import javafx.beans.binding.IntegerBinding;
import org.mumyoutube.model.Video;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mumyoutube.controller.VideoUploadController.uploadingDir;


@RestController
@RequestMapping

public class VideoplayListController {

    @Autowired
    private MyResourceHttpRequestHandler handler;
    @Autowired
    VideoService videoService;
    static ModelAndView mv = new ModelAndView();


    File MP4_FILE;

    public VideoplayListController(VideoService videoService) {
        super();
        this.videoService = videoService;
    }

    List<Long> videoIds;
    List<String> exactPaths;
    List<String> newVideoPath = new ArrayList<>();

    @GetMapping(value = "/playVideo"/*, produces = "video/mp4"*/)
    @ResponseBody
    public ModelAndView videoSource(HttpServletRequest request,
                                    HttpServletResponse response)
            throws ServletException, IOException {
        exactPaths = new ArrayList<>();
        List<String> vidP = new ArrayList<>();
        videoIds = new ArrayList<>();

        List<Video> vids = videoService.getAllVideo();


        for (Video v : vids) {
            exactPaths.add(v.getVideoPath());
            videoIds.add(v.getVideoId());

            newVideoPath.add(v.getVideoPath().split(Pattern.quote(File.separator))[7]);

            MP4_FILE = new File(v.getVideoPath());
            vidP.add(MP4_FILE.getName());

//            request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
//            handler.handleRequest(request, response);
//            mv.addObject(handler);
        }
        //List<Video> viddleeo = videoService.getAllVideo();

//        List v = Files.list(Paths.get(uploadingDir)).collect(Collectors.toList());
//        List vPath = new ArrayList();
//        for (Object s : v) {
//            vPath.add(Paths.get(s.toString()).getFileName());
//        }
        mv.addObject("Paths", exactPaths);
        mv.addObject("VideoIds", videoIds);

        mv.addObject("videos", vidP);

        return mv;
    }

//    @GetMapping(path = "/plain", produces = "video/mp4")
//    public FileSystemResource plain() {
//
//        return new FileSystemResource(MP4_FILE);
//    }

    //@GetMapping("/{videoName}")
    //@NotNull
    @GetMapping(value = "/{Paths}", produces = "video/mp4")
    public ModelAndView video(@PathVariable String Paths, HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
//        String id =
        int id = 0;
        if (newVideoPath.contains(Paths)) {
            int pos = newVideoPath.indexOf(Paths);
            id = Math.toIntExact(videoIds.get(pos));
        }else{
            System.out.println("Not found");
        }
        MP4_FILE = new File(uploadingDir + "/" + Paths);
        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);


//        Path fullPath = Path.of(uploadingDir + "/" + videoName);
//        ModelAndView model = new ModelAndView();
//        model.addObject("path",  handler.getResource(request));
//
        ModelAndView modelAndView = new ModelAndView("video");
        modelAndView.addObject(id);
        return new ModelAndView("video");
    }


    @Component
    final static class MyResourceHttpRequestHandler extends ResourceHttpRequestHandler {

        private final static String ATTR_FILE = MyResourceHttpRequestHandler.class.getName() + ".file";

        @Override
        protected Resource getResource(HttpServletRequest request) throws IOException {

            final File file = (File) request.getAttribute(ATTR_FILE);
            return new FileSystemResource(file);
        }
    }


    /*@RequestMapping(value = "/video", method = RequestMethod.GET)
    public String playVideo() {
        return "video";
    }*/
}
