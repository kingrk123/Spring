package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageGeneratorService;

@Controller
public class WishMessageController {
	@Autowired
	 private WishMessageGeneratorService  service;
	
	@RequestMapping("/home.htm")
	public  String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/wish.htm")
	public  String generateMsg(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		//keep result as model attribute
		map.put("wMsg",msg);
		//return LVN
		return "show_result";
	}

}
