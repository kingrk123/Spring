package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesOperationController {
	
	@RequestMapping("/home.htm")
	public  String showHomePage() {
		return "page1Def";
	}
	
	@RequestMapping("/courses.htm")
	public  String ShowCoursePage() {
		return "page2Def";
	}
	
	@RequestMapping("/faculties.htm")
	public  String ShowFacultiesPage() {
		return "page3Def";
	}
	
	@RequestMapping("/address.htm")
	public  String ShowAddressPage() {
		return "page4Def";
	}


}
