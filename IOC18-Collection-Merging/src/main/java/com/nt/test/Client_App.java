package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.EnggCourse;

public class Client_App {

	public static void main(String[] args) {
		BeanFactory factory =null;
		EnggCourse eng=null;
		
		//Create IOC Container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Create Engg Course Object
		eng=factory.getBean("e2",EnggCourse.class);
		System.out.println(eng);

	}

}
