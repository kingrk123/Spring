package com.nt.beans;

import java.beans.XMLDecoder;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class ProfesitionalCricketer {
	private String name;
	private String beanId;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	public void  bowling() {
		System.out.println(name+" crickter is  bowling");
	}
	public void  fielding() {
		System.out.println(name+" crickter is  fielding");
	}
	
	public void batting() {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader= null;
		CricketBat bat=null;
		
		//Create IOC Container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Dependent class object (Dependancy Lookup)
		bat= factory.getBean(beanId,CricketBat.class);
		System.out.println(name+" Cricketer is batting");
		bat.scoreRuns();
	}
	
}
