package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	
	public StudentServiceImpl(StudentDAO dao) {
		System.out.println("StudentServiceImpl.StudentServiceImpl()");
		this.dao=dao;
	}
	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total = 0;
		int avg = 0;
		String result = null;
		int count =0;
		StudentBO bo=null;
		total = dto.getM1()+dto.getM2()+dto.getM3();
		avg = total/3;
		if (dto.getM1()>=35 && dto.getM2()>=35 && dto.getM3()>=35) {
			result=" Pass";			
		}else
			result=" Fail";
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		count= dao.insert(bo);
		if(count==0)
			return "Student Registration Failed :::  result   is-->"+result;
		else 
			return "Student Registration Succeded :::  result   is-->"+result;	
	}
}
