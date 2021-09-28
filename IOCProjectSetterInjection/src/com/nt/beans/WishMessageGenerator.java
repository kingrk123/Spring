package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date;
	
	public WishMessageGenerator() {
		System.out.println("WishMssgGenerator: 0-Param");
	}
	
	public void setdate() {
		System.out.println("WishMssgGenerator: Setdate(-)");
		this.date = date;
	}

	
	public void Mul(int a, int b) {
		int c;
		c=a*b;
		System.out.println("Multiplication is:"+c);
		
	}

	public String generate(String user) {
		System.out.println("Injected date :"+date);
		int hour = 0;
		// get current hour of the day
		hour = date.getHours();
		// generates Wish Messgae
		if (hour < 12)
			return "Good Morning::" + user;
		else if (hour < 16)
			return "Good AfterNoon::" + user;
		else if (hour < 20)
			return "Good Evening::" + user;
		else
			return "Good Night::" + user;
	}// method
}


