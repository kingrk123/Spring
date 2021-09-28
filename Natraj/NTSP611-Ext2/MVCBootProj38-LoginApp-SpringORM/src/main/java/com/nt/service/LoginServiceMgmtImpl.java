package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;
import com.nt.entity.User;

@Service("loginService")
public class LoginServiceMgmtImpl implements LoginServiceMgmt {
	@Autowired
	private LoginDAO  dao;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED,transactionManager = "hbTxMgmr")
	public String authenticate(UserDTO dto) {
		long count=0;
		User user=null;
		//convert DTO to Entiy object
		user=new User();
		BeanUtils.copyProperties(dto, user);
		//use DAO
		count=dao.validate(user);
		if(count==0)
			 return "InValid Credentials";
		else
			return "Valid Credentails";
	}

}
