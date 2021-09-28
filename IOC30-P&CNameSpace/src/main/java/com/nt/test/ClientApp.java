package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Emp;

public class ClientApp {

	public static void main(String[] args) {
		//Create IOc Container
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//Get Bean
		Emp emp =ctx.getBean("emp",Emp.class);
		System.out.println(emp);
	}//main

}//class
