package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CricketBat;
import com.nt.beans.ProffestionalCricketer;

public class Clent_App {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader =null;
		ProffestionalCricketer cricketer=null;
		CricketBat bat=null;
		//Create IOC Container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//Target class of Object
		
		cricketer=factory.getBean("pc", ProffestionalCricketer.class);
		cricketer.batting(factory);
		cricketer.fielding();
		cricketer.bowling();
		
	}

}
