package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.BankAccount;
import com.nt.beans.BankCustomer;

public class InnerBean {

	public static void main(String[] args) {
		BeanFactory factory =null;
		BankCustomer customer=null;
		BankAccount account =null;
		//Create IOC Container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Target Bean Class Object
		customer=factory.getBean("cust",BankCustomer.class);
		System.out.println("Account Balance "+customer.getBalance());
		System.out.println(customer);
		System.out.println("-------------------");
	}

}
