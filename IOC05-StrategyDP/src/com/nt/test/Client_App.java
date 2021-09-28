package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Vehicle;

public class Client_App {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory = null;
		Object obj = null;
		Vehicle generator = null;
		
		//Locate cfgs file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory = new XmlBeanFactory(res);
		//Create Target bean
		obj = factory.getBean("vehicle");
		generator =(Vehicle)obj;
		
		generator.journery("Hyderabad", "Mumbai");
		System.out.println("---------------");
		generator.journery("Banglore", "Delhi");
	}

}
