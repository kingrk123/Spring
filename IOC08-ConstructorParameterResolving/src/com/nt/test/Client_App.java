package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Employee;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class Client_App {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory =null;
		Object obj = null;
		Student std=null;
		Marks mks =null;
		Employee empe=null;
		
		//Locate IOC Cfgs
		res= new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//Create IOC Container
		factory = new XmlBeanFactory(res);
		//get Target Bean
//		obj=factory.getBean("stud");
//		obj=factory.getBean("mk");
//		obj=factory.getBean("emp");
//		std=(Student)obj;
//		System.out.println(std);
//		System.out.println("-----------------");
//		mks=(Marks)obj;
//		System.out.println(mks);
//		System.out.println("------------------");
//		empe=(Employee)obj;
//		System.out.println(empe);
//		System.out.println("-------------------");
		std=factory.getBean("stud",Student.class);
		System.out.println(std);
		System.out.println(".............................");
		mks=factory.getBean("mk",Marks.class);
		System.out.println(mks);
		System.out.println(".................................");
		empe=factory.getBean("emp",Employee.class);
		System.out.println(empe);

	}

}
