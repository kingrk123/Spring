package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Construct_Injection;

public class Client_App {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory = null;
		Object obj = null;
		Construct_Injection generator =null;
		//locate bean cfgs file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory = new XmlBeanFactory(res);
		//Target Bean
		obj = factory.getBean("ci");
		obj = factory.getBean("pa");
		generator=(Construct_Injection)obj;
		
		System.out.println("Result :: "+generator.generate());

	}

}
