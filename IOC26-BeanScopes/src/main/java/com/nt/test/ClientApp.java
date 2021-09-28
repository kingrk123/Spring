package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class ClientApp {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Object obj=null,obj1=null;
		 Printer p1=null,p2=null;
		 WishMessageGenerator generator=null;
		
		//Create IOC Container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean WishMessgeGenerator
		obj=factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("---------------------------");
		obj1=factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println(obj.hashCode()+"  "+obj1.hashCode());
		 System.out.println("obj==obj1?"+(obj==obj1));
		 System.out.println("==============================");
		 //get Bean Printer
		 p1=factory.getBean("pu",Printer.class);
		 p2=factory.getBean("pu",Printer.class);
		 System.out.println(p1.hashCode()+"   "+p2.hashCode());
		 System.out.println("p1==p2?"+(p1==p2));
		}

}
