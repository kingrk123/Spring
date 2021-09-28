package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.bo.StudentBO;
import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class ClientApp {
	
	public static void main(String[] args) {
		Resource res =null;
		BeanFactory factory =null;
		Object obj =null;
		MainController controller=null;
		StudentBO bo =null;
		String result=null;
		StudentVO  vo=null;
		Scanner sc=null;
		String name=null,m1=null,m2=null,m3=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter Student name::");
		name=sc.next();
		System.out.println("Enter student marks1::");
		m1=sc.next();
		System.out.println("Enter Student marks2::");
		m2=sc.next();
		System.out.println("Enter Student marks3::");
		m3=sc.next();
		//create StudentVO class object
		vo=new StudentVO();
		vo.setSname(name);
		vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
		
		//locate the cfgs file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory =new XmlBeanFactory(res);
		//Target Bean Class
		obj = factory.getBean("controller");
		controller = (MainController)obj;
		
		try {
			/*
			 * System.out.println(bo.getSname()); System.out.println(bo.getTotal());
			 */
			result=controller.process(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Internal Problem ----> try again..");
			e.printStackTrace();
		}
	}
}
