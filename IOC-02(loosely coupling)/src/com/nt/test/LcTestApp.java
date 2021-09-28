package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Flipkart;

public class LcTestApp {
	public static void main(String[] args) {
		//create beanFactory obj to create IOC container
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));
		//Get bean obj
		Flipkart bean = factory.getBean("fpk",Flipkart.class);
		String billmsg = bean.purchase(new String[] {"shirt","mobile","books"});
		System.out.println(billmsg);
	}//main
}//class
