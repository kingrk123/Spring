package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class Client_App {

	public static void main(String[] args) {
		BeanFactory factory=null;
		A aa=null;
		B bb=null;
		
		//Create IOC Container
		factory =new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		aa=factory.getBean("a1", A.class);
		System.out.println(aa);
		System.out.println("-----------------");
		bb=factory.getBean("b1", B.class);
		System.out.println(bb);
		System.out.println("-------------------");
		

	}

}
