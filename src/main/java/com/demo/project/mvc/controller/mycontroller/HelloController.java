package com.demo.project.mvc.controller.mycontroller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Model model) {
		model.addAttribute("message", "This is Example with Tiles & MVC.");
		return "hello";
	}
}