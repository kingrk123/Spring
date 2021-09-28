package com.nt.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Viechle {
	private String beanId;

	public Viechle() {
		System.out.println("Viechle :: 0-Param Constructor");
	}
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	public void move() {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader = null;
		//Create IOC Container
		factory=new DefaultListableBeanFactory();
		reader =new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//Create Objects for Engine
		Engine engine=factory.getBean("beanId",Engine.class);
		engine.start();
		System.out.println("Viechle moved for Journey");
	}
}
