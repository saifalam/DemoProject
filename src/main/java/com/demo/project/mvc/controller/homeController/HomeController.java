package com.demo.project.mvc.controller.homeController;

/**
 * Created by saif on 4/8/15.
 */
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
//     @RequestMapping(method = RequestMethod.GET)
//     public String printWelcome(Model model) {
//         model.addAttribute("message", "This is Example with Tiles & MVC.");
//         return "hello";
//     }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(Model model) {
         model.addAttribute("message", "This is Example with Tiles & MVC.");
         return "hello";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHome(Model model) {
        model.addAttribute("message", "This is Home page of Demo project.");
        return "home";
    }

    @RequestMapping(value = "/login/error",method = RequestMethod.GET)
    public String loginSecurityError(Model model ) {
        model.addAttribute("message","Login failed with Spring security error... :(");
        return "hello";
    }

}