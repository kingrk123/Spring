package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Setter_Injection;

public class Client_App {

	public static void main(String[] args) {
		Resource res =null;
		BeanFactory factory = null;
		Object obj = null;
		Setter_Injection generator = null;
		
		//locate Spring Bean cfgs file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory = new XmlBeanFactory(res);
		//Target Bean class
		obj =factory.getBean("si");
		generator =(Setter_Injection)obj;
		System.out.println("Result ::"+generator.generate());
	}

}
