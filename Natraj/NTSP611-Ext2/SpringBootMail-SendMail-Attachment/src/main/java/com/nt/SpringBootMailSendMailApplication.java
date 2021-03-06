package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.OrderService;

@SpringBootApplication
public class SpringBootMailSendMailApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(SpringBootMailSendMailApplication.class, args);
		//get Service class object
		OrderService service=ctx.getBean("orderService",OrderService.class);
		//invoke method
		System.out.println(service.generateBill(new String[] {"roses","chocolates","teddybare"},new float[]{500.0f,1000.0f,800.0f},"natarazjavaarena@gmail.com"));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
