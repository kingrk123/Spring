package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class MainController {
	private StudentService service =null;
	
	 public MainController(StudentService service) {
		this.service=service;
	}
	 public String process(StudentVO vo) throws Exception {
		 StudentDTO dto =null;
		 String result = null ;
		 //convert vo to dto
		 dto =new StudentDTO();
		 
		 dto.setSname(vo.getSname());
		 dto.setM1(Integer.parseInt(vo.getM1()));
		 dto.setM2(Integer.parseInt(vo.getM2()));
		 dto.setM3(Integer.parseInt(vo.getM3()));
		 
		 result =service.generateResult(dto);
		 return result;
	 }
}
