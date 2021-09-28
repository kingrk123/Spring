package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Bike;

public class Client_Test {

	public static void main(String[] args) {
		BeanFactory factory=null;
		Bike bike=null;
		Bike bike1=null;
		
		//Create IOC Container
		factory =new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Bike Class Objects
		bike = factory.getBean("b2",Bike.class);
		System.out.println(bike);
		System.out.println("-------------------------");
		bike1 =factory.getBean("b3",Bike.class);
		System.out.println(bike1);
		System.out.println("---------------------------");

	}

}
