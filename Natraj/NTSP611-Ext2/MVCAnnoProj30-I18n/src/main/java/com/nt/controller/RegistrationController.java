package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.command.RegisterCommand;

@Controller
public class RegistrationController {
	
	@GetMapping("/register.htm")
	public String  showForm(@ModelAttribute("regCmd")RegisterCommand cmd) {
		return  "register_form";
	}

}
