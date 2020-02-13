package org.mumyoutube.comment;

import com.mysql.cj.conf.MemorySizePropertyDefinition;
import org.mumyoutube.config.AppConfig;
import org.mumyoutube.model.Comment;
import org.mumyoutube.service.UserServiceImpl;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserServiceImpl userService;

    int videoId;


//    @GetMapping
//    public List<Comment> getAllComment() {
//        return commentService.getAllComment();
//    }

    /*Rest Api*/
/*
    @GetMapping("/video/{video_id}")
    public List<Comment> getAllComment(@PathVariable int video_id) {
        System.err.println("data " + video_id);
        return commentService.getAllComment(video_id);
    }
*/

    @GetMapping("/video/{video_id}")
    public ModelAndView getAllComment(@PathVariable int video_id) {
        System.err.println("data " + video_id);
        videoId = video_id;

        ModelAndView modelAndView = new ModelAndView("comment");
        ArrayList<String> comments = new ArrayList<>();
        ArrayList<String> username = new ArrayList<>();

        for (Comment comment : commentService.getAllComment(video_id)) {
            comments.add(comment.getComment());
            username.add(comment.getUsername());
        }

//        for (Comment comment : commentService.getAllComment(video_id)) {
//            username.add(userService.getUserById(comment.getUserId()).getUserName());
//        }
        modelAndView.addObject("comment", comments);
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @PostMapping("/video/comment")
    public RedirectView saveComment(@ModelAttribute("CommentBody") Comment comment, HttpServletRequest request) {
//
//        String username;
//         username=request.getUserPrincipal().getName();
//
//        System.err.println("Username is is is " + username);
        // HttpSession session = httpSessionFactory.getObject();
        //  String id = (String) session.getAttribute("userId");
        // System.err.println("username is " + id);
        comment.setUserId(1);
        comment.setUsername(AppConfig.getId());
        comment.setVideoId(videoId);
        commentService.addComment(comment);

        ModelAndView mv = new ModelAndView("comment");
        mv.addObject("playVideo");
        return new RedirectView("/playVideo" , false);

        //return mv;
    }

    @DeleteMapping("/comment/{comment_id}")
    public void deleteComment(@PathVariable("comment_id") int commentId) {
        commentService.deleteComment(commentId);
    }
}
