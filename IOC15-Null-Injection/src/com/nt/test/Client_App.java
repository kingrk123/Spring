package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Personal_Info;

public class Client_App {

	public static void main(String[] args) {
		BeanFactory factory = null;
		Personal_Info P_Info = null;
		
		//Creating IOC Container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		P_Info =factory.getBean("pi", Personal_Info.class);
		System.out.println(P_Info);
	}

}
