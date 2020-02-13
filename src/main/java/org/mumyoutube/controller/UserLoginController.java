package org.mumyoutube.controller;

import org.mumyoutube.model.Playlist;
import org.mumyoutube.model.User;
import org.mumyoutube.model.Video;
import org.mumyoutube.service.UserServiceImpl;
import org.mumyoutube.service.VideoService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserLoginController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, Model model) {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        model.addAttribute("uri", request.getRequestURI())
                .addAttribute("user", auth.getName())
                .addAttribute("roles", auth.getAuthorities());
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute User loginBean, BindingResult result, HttpServletRequest servletRequest) {

        servletRequest.setAttribute("mode", "playVideo");
        //ModelAndView mv = new ModelAndView();
//        mv.setViewName("dashboard");
        //data();
        return "playVideo";
    }

    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public ModelAndView displayNewPlaylistForm() {
        ModelAndView mv = new ModelAndView("charts");
        mv.addObject("headerMessage");
        return mv;
    }


    @Autowired
    VideoService videoService;

    public void data() {
        List<String> exactPaths = new ArrayList<>();
        List<String> vidP = new ArrayList<>();

        List<Video> vids = videoService.getAllVideo();


        for (Video v : vids) {
            exactPaths.add(v.getVideoPath());

//            MP4_FILE = ;
            vidP.add(new File(v.getVideoPath()).getName());

        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Paths", exactPaths);

        modelAndView.addObject("videos", vidP);

    }
}
