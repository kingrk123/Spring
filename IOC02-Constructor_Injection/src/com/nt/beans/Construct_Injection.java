package com.nt.beans;

import java.util.Date;

public class Construct_Injection {
	private String name;
	private Date date;
	
	static {
		System.out.println("Static Constructor");
	}

	public Construct_Injection() {
		System.out.println("0-Param Constructor");
	}
	
	public Construct_Injection(Date date) {
		System.out.println("1-Param Constructor");
		System.out.println(date);
		this.date=date;
	}
	
	public Construct_Injection(String name, Date date) {
		System.out.println("2-Param Constructor");
		this.name=name;
		this.date=date;
		System.out.println(name+" "+date);
	}
	public String generate() {
		int hour =0;
		System.out.println(date);
		hour = date.getHours();
		if(hour<=12)
			return "Good Morning "+name;
		else if(hour<=16)
			return "Good AfterNoon "+name;
		else if(hour<=20)
			return "Good Evening "+name;
		else
			return "Good Night "+name;
		
	}

}
