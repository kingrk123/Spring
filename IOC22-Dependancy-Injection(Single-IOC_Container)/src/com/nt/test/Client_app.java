package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CricketBat;
import com.nt.beans.ProffesitionalCricketer;

public class Client_app {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader =null;
		CricketBat bat=null;
		ProffesitionalCricketer proff=null;
		
		//Create IOC Container
		factory =new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//Target Object Class
		bat=factory.getBean("cb",CricketBat.class);
		proff=factory.getBean("pc",ProffesitionalCricketer.class);
		
		proff.batting(factory, bat);
		proff.fielding();
		proff.bowling();
		
	}

}
