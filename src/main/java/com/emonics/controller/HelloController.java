package com.emonics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping(value = "/hello")
	public String hello(@RequestParam String name, Model model) {
		System.out.println("Entering Hello method " + name);
		model.addAttribute("nameParam", name);
		return "home";
	}
}
