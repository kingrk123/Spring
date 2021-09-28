package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.WishMessageGenerator;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory =null;
		//Create IOC Container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		
		WishMessageGenerator generator=null;
		
		generator=factory.getBean("wsg",WishMessageGenerator.class);

		System.out.println("Result::"+generator.Generater("KingRk"));
		System.out.println("----------------------");
		System.out.println();
	}

}
