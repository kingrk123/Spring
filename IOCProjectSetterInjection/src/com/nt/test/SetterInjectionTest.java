package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Object obj=null;
		WishMessageGenerator generator=null;
		
		//Locate Spring Bean cfg file
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
	   //create IOC container  (BeanFactory)
		factory=new XmlBeanFactory(res);
		//get Target Bean class object
		obj=factory.getBean("wmg");
		generator=(WishMessageGenerator)obj;
		//invoke b.method
		//System.out.println("Result is ::" generator.Mul(5, 4));
		System.out.println("Result is ::"+generator.generate("KingRK"));

	}

}
