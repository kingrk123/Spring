package com.nt.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.BeanConfigure;
import com.nt.beans.Student;
import com.nt.beans.WishGenerator;

public class TestClient {

	public static void main(String[] args) {
		//create IOC Container
		ApplicationContext ac = new 
				AnnotationConfigApplicationContext(BeanConfigure.class);
	WishGenerator wg = ac.getBean(WishGenerator.class);
	System.out.println(wg);
	
	System.out.println("==============");
	
	Student st = ac.getBean("st",Student.class);
	System.out.println(st);
	
	System.out.println("==============");
	
	Date d = ac.getBean(Date.class);
	System.out.println(d);
	}

	
}
