package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.controller.StudentController;
import com.nt.vo.StudentVO;

public class Client_App {

	public static void main(String[] args) {
		Resource res =null;
		BeanFactory factory =null;
		Object obj =null;
		StudentController controller =null;
		
		String result=null;
		StudentVO  vo=null;
		Scanner sc=null;
		String no=null,name=null,addrs=null,m1=null,m2=null,m3=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter Student number::");
		no=sc.next();
		System.out.println("Enter Student name::");
		name=sc.next();
		System.out.println("Enter marks1::");
		m1=sc.next();
		System.out.println("Enter Student marks2::");
		m2=sc.next();
		System.out.println("Enter Student marks3::");
		m3=sc.next();
		//create StudentVO class object
		vo=new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
		res =new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC container
		factory = new XmlBeanFactory(res);
		//get Bean Controller class object
		obj =factory.getBean("stcontroller");
		controller = (StudentController)obj;
		//controller=factory.getBean("stcontroller",StudentController.class);
		try {
			result=controller.process(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Internal Problem ----> try again..");
			e.printStackTrace();
		}
		

	}

}
