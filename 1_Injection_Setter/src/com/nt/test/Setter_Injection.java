package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.Bean.WishMssgGenerator;

public class Setter_Injection {

	public static void main(String[] args) {
		Resource res =null;
		BeanFactory factory = null;
		Object obj = null;
		WishMssgGenerator generate = null;
		
		//locate the configuration File
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container(Bean Factory)
		factory = new XmlBeanFactory(res);
		//Target Bean class
		obj =factory.getBean("wsg");
		generate = (WishMssgGenerator)obj;
		
		//call Method
		System.out.println(generate.WishMessageGenerator());
		System.out.println(generate.Mul(5, 10));
		


	}

}
