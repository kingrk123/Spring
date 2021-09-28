package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Viechle;

public class Client_App {

	public static void main(String[] args) {
		BeanFactory factory=null;
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		Viechle viechle=factory.getBean("vi",Viechle.class);
		viechle.move();
	}

}
