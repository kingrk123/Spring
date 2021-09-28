package com.nt.beans;

import java.util.Date;

public class Setter_Injection {
	private String name;
	private Date date;
	
	public Setter_Injection() {
		System.out.println("0-param Constructor");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Setter_Injection.setName() "+name);
	}

	public void setDate(Date date) {
		System.out.println("Setter_Injection.setDate()");
		this.date = date;
	}
	public String generate() {
		System.out.println("Setter Injection");
		int hour =0;
		hour = date.getHours();
		
		if(hour<=12)
			return "Good morning "+name;
		else if(hour<=16)
			return "Good AfterNoon "+name;
		else if(hour<=20)
			return "Good Evening "+name;
		else
			return "Good Night "+name;
		
		
	}
	
}
