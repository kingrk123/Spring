package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ProfesitionalCricketer;

public class Client_App {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader =null;
		ProfesitionalCricketer cricketer=null;
		
		//Create IOC Container
		factory =new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Target Class Objects
		cricketer=factory.getBean("crt",ProfesitionalCricketer.class);
		//invoked Method
		cricketer.batting();
		cricketer.fielding();
		cricketer.bowling();
		
	}

}
