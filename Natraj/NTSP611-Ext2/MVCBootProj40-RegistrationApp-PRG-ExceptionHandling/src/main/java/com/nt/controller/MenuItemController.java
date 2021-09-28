package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.command.ItemDetailsCommand;
import com.nt.dto.ItemDetailsDTO;
import com.nt.service.MenuItemMgmtService;

@Controller
public class MenuItemController {
	@Autowired
	private MenuItemMgmtService service;

	
	@GetMapping("/register.htm")
	public String   showForm(@ModelAttribute("iCmd")ItemDetailsCommand cmd) {
		return "item_register";	
	}
	

	 @PostMapping("/register.htm")
	public String processForm(RedirectAttributes attributes,@ModelAttribute("iCmd") ItemDetailsCommand cmd) {
		 System.out.println("MenuItemController.processForm()");
		String rMsg=null;
		ItemDetailsDTO dto=null;
		//convert cmd to dto
		dto=new ItemDetailsDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		rMsg=service.registerMenuItem(dto);
		//result isn model attribute
		attributes.addFlashAttribute("result", rMsg);
		//return lvn
		return "redirect:/post_result.htm";
	}
	 
	 @GetMapping("/post_result.htm")
	 public String   showResultPage() {
		 System.out.println("MenuItemController.showResultPage()");
		 return "show_result";
	 }
	
	

}
