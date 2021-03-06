package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
//@SessionAttributes(value = "userCmd",types = UserCommand.class)
public class LoginController {
	@Autowired
	private  LoginService service;
	
	
	
		@GetMapping("/login.htm")  // for Initial Phase request
		public  String  showForm(Map<String,Object> map) {
			UserCommand cmd=null;
			//create Command object
			cmd=new UserCommand();
			cmd.setUser("raja");
			map.put("userCmd",cmd);
			return "login_form";
		}
	
	@PostMapping("/login.htm")   //for post back request
	public String  processForm(Map<String,Object> map,
			                                          @Valid @ModelAttribute("userCmd")UserCommand cmd,
			                                          BindingResult errors) {
		UserDTO dto=null;
		String result=null;
		
		if(errors.hasErrors())
			return "login_form";
		
		//convert cmd  to DTO
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		result=service.validate(dto);
		//keep result as model attribute
		map.put("resultMsg",result);
		map.put("cmdData", cmd);
		return "login_result";
	}
	
	@InitBinder
	public    void myInitBinder(WebDataBinder binder) {
		 SimpleDateFormat sdf=null;
		 sdf=new SimpleDateFormat("dd-MM-yyyy");
		 binder.registerCustomEditor(Date.class,
				                                                   new CustomDateEditor(sdf,true));
	}
	
	
	

}
