package com.main.controller;

import javax.management.AttributeValueExp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

@Controller
public class helloController {
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data","hello");
		return "index";
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(Model model,@RequestParam("name") String name) {
		model.addAttribute("name",name);
		return "hello-template";
	}
	
}
