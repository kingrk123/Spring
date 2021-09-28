package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageGenerator;

@Controller
public class WishOperationsController {
	@Autowired
	private WishMessageGenerator service;
	
	
	@RequestMapping("/home.htm")
	public  String  showHomePage() {
		return  "welcome";
	}
	
	
	@RequestMapping("/wish.htm")
	public  String  showWishMessage(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		//keep result in model attribute
		map.put("wMsg",msg);
		return "show_result";
	}

}
