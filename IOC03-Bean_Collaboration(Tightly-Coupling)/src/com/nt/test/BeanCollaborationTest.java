package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class BeanCollaborationTest {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory = null;
		Object obj =null;
		Flipkart generator =null;
		
		//Locate the cfgs file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory =new XmlBeanFactory(res);
		//Target Bean
		obj =factory.getBean("fkart");
		generator =(Flipkart)obj;
		
		System.out.println(generator.purchase(new String[] {"fruits","flowers","sweets","shirt","trousher"}));


	}

}
