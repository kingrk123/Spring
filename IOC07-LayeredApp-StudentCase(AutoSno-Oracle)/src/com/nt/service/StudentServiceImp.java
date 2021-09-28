package com.nt.service;

import java.util.concurrent.CountDownLatch;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImp implements StudentService {
	private StudentDAO dao;
	public StudentServiceImp(StudentDAO dao) {
		this.dao=dao;
	}

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total=0;
		int avg = 0;
		String result =null;
		int count=0;
		StudentBO bo =null;
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg = total/3;
		
		if (dto.getM1()>=35 && dto.getM2()>=35 && dto.getM3()>=35) {
			result ="Pass";
		}else {
			result ="Fail";
		}
		
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		count=dao.insert(bo);
		if(count==0)
			return "Student Registration is Failed "+result;
		else
			return "Student Registration is Successed "+result;
		
	}

}
