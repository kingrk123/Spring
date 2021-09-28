package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.WishMessageGenerator;

public class Client_App {

	public static void main(String[] args) {
		BeanFactory factory = null;
		WishMessageGenerator w1=null,w2=null,w3=null;
		//Create IOC Container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Create Object For WishGenerator
		w1=factory.getBean("wsg",WishMessageGenerator.class);
		System.out.println(w1);
		System.out.println("----------------------------");
		w2=factory.getBean("sg",WishMessageGenerator.class);
		System.out.println(w2);
		System.out.println("-----------------------------");
		w3=factory.getBean("g",WishMessageGenerator.class);
		System.out.println(w3);
		System.out.println(w1.hashCode()+" "+w2.hashCode()+" "+w3.hashCode());
	}

}
