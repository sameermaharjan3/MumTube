package org.mumyoutube.controller;

import org.mumyoutube.model.User;
import org.mumyoutube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
 //       userService.saveUser(user);
  //      request.setAttribute("mode", "login");
        return "l";
    }
}
