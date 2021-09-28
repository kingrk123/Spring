package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.Robot;

public class TestClient {

	public static void main(String[] args) {
		//create IOC Container
		ApplicationContext ac = 
				new FileSystemXmlApplicationContext(
						"src/main/java/com/nt/cfgs/applicationContext.xml");
		
		//get bean
		Robot robot = ac.getBean("robot", Robot.class);
		System.out.println(robot);
	}
}
