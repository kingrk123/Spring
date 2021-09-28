package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.BankLoanApprover;

public class clientApp {

	public static void main(String[] args) {
		//Create parent IOC Container (Parent Bean Factory)
		BeanFactory pfactory = new XmlBeanFactory(new FileSystemResource("src/main/java/com/nt/cfgs/Loan-beans.xml"));
		//Create child IOC container (Child Bean Factory)
		BeanFactory cfactory= new XmlBeanFactory(new FileSystemResource("src/main/java/com/nt/cfgs/approval-bean.xml"),pfactory);
		//get Bean
		BankLoanApprover approver=cfactory.getBean("bla",BankLoanApprover.class);
		System.out.println(approver.approveLoan());
	}//main
}//class
