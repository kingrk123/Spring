package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMssgGenerator;

public class Cons_Injection {

	public static void main(String[] args) {
		System.out.println("start of main(-)");
		Resource res=null;
		BeanFactory factory=null;
		Object obj=null,obj1=null,obj2=null;
		WishMssgGenerator generator=null;
		//Locate Spring Bean cfg file
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//res=new ClassPathResource("applicationContext.xml");
		System.out.println("Spring Bean cfg file is name specified");
	   //create IOC container  (BeanFactory)
		factory=new XmlBeanFactory(res);
		System.out.println("IOC container is created");
		//get Target Bean class object
		obj=factory.getBean("wmg");
		generator=(WishMssgGenerator)obj;
		System.out.println("Target Bean class object is gathered");
		//invoke b.method
		System.out.println("Result is ::"+generator.generate("KingRK"));
		System.out.println("end of main method"); 		

	}

}
