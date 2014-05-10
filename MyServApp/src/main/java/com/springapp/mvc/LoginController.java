package com.springapp.mvc;


import DataEntities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String login(HttpSession session, Model model){
        User user = new User();

        model.addAttribute("user",user);
        session.setAttribute("isAuth","true");
        return "login";
    }


    @RequestMapping(value = "/signup" ,method = RequestMethod.POST)
    public String login(@ModelAttribute User user, HttpSession session, Model model){



        session.setAttribute("isAuth","true");
        return "redirect:/";
    }
}