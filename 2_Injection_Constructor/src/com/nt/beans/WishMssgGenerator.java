package com.nt.beans;

import java.util.Date;

public class WishMssgGenerator {
	private Date date;
	static {
		System.out.println("WishMessageGenerator::static block");
	}
	
	private WishMssgGenerator(Date dat) {
		this.date=dat;
		System.out.println("WishMessageGenerator::1-param constructor");
	}

	
	  public void setDate(Date date) {
	  System.out.println("WishMessageGenerator:setDate(-)"); 
	  this.date = date; 
	  }
	 
	
	public String generate(String user) {
		System.out.println("WishMessageGenerator:generate(-) metthod:::"+date);
		int hour=0;
		//get current hour of the day
		hour=date.getHours();
		//generates Wish Messgae
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good AfterNoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night::"+user;
	}//method
}
