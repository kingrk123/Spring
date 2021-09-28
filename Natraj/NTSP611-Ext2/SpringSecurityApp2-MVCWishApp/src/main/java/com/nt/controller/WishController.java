package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	 private WishService service;
	
	@RequestMapping("/home.htm")
	public  String  showHomePage() {
		return "welcome";
	}
	
		@RequestMapping("/wish.htm")
		public   String  process(Map<String,Object> map) {
			String resultMsg=null;
			//use service
     	resultMsg=service.generateWishMessage();
			//return MAV
			map.put("resMsg",resultMsg);
			return "result";
		}

}
