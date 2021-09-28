package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.Bean.WishMssgGenerator;

public class Setter_injection {

	public static void main(String[] args) {
		
		Resource res = null;
		BeanFactory factory = null;
		Object obj = null;
		WishMssgGenerator generator = null;

		res = new FileSystemResource("/src/com/nt/cfgs/applicationContext.xml");
		factory=new XmlBeanFactory(res);
		
		obj= factory.getBean("wsg");
		generator=(WishMssgGenerator)obj;
		
		System.out.println("Result:"+generator.generate("KingRk"));
	}

}
