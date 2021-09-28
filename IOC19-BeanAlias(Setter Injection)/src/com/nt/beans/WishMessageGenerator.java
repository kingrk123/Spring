package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date;
	public void setDate(Date date) {
		this.date = date;
	}
	static {
		System.out.println("Static Block()");
	}
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator()::0 Param Constructor");
	}
	public String generate() {
		int hour=0;
		hour=date.getHours();
		
		if(hour<=12)
			return "Good Morning" ;
		else if(hour<=16)
			return "Good AfterNoon" ;
		else if(hour<=20)
			return "Good evening" ;
		else 
			return "Good Night" ;
	}
}
