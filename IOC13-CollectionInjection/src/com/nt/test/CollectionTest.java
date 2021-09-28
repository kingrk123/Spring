package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.College;
import com.nt.beans.Faculties_Info;
import com.nt.beans.FruitStore;
import com.nt.beans.Marks;
import com.nt.beans.Personal_Info;

public class CollectionTest {

	public static void main(String[] args) {
		BeanFactory factory =null;
		College college =null;
		Marks marks =null;
		Personal_Info personal=null;
		Faculties_Info faculty=null;
		FruitStore fruitStore=null;
		
		//Create IOC Container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Creating College Bean
		college =factory.getBean("clg",College.class);
		System.out.println(college);
		System.out.println("-------------------------");
		//Creating Marks Bean
		marks =factory.getBean("mk",Marks.class);
		System.out.println(marks);
		System.out.println("-------------------------");
		//creating Personal Info Bean
		personal=factory.getBean("pi",Personal_Info.class);
		System.out.println(personal);
		System.out.println("--------------------------");
		//Creating Faculties Info Bean
		faculty=factory.getBean("fi",Faculties_Info.class);
		System.out.println(faculty);
		System.out.println("---------------------------");
		//Creating Fruit Store Bean
		fruitStore=factory.getBean("fs", FruitStore.class);
		System.out.println(fruitStore);
		System.out.println("-----------------------------");
	}

}
