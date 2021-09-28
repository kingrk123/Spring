package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginServiceMgmt;

@Controller
public class LoginController {
	@Autowired
	private LoginServiceMgmt service;
	
	@GetMapping("/login.htm")
	public   String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		return "login_form";
	}
	
	
	@PostMapping("/login.htm")
	public   String processForm(Map<String,Object> map,@ModelAttribute("userCmd") UserCommand cmd) {
      String resultMsg=null;
      UserDTO dto=null;
      //convert Command to DTO
      dto=new UserDTO();
      BeanUtils.copyProperties(cmd, dto);
		//use service
      resultMsg=service.authenticate(dto);
      map.put("result",resultMsg);
      return "show_result";
	}

}
