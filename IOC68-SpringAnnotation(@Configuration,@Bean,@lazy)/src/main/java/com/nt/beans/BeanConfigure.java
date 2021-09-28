package com.nt.beans;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfigure {

	public BeanConfigure() {
		System.out.println("BeanConfigurator:0-param constructor");
	}

	@Bean(name = "st")
	@Lazy(value = true)
	@Scope("prototype")
	public Student createStudent() {
		System.out.println("createStudent()");
		return new Student();
	}
	
	@Bean
	@DependsOn("st")
	public Date createDate() {
		System.out.println("createDate()");
		return new Date();
	}
	
	@Bean
	public WishGenerator createWishGenerator() {
		System.out.println("createWishGenerator()");
		return new WishGenerator();
	}
	
}
