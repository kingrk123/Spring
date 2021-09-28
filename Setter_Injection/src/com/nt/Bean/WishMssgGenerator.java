package com.nt.Bean;

import java.util.Date;

public class WishMssgGenerator {
	private Date date;
	
	public WishMssgGenerator() {
		System.out.println("WishMssgGenerator: 0-Param");
	}
	
	public void setdate() {
		System.out.println("WishMssgGenerator: Setdate(-)");
		this.date = date;
	}
	
	public String generate(String user) {
		System.out.println("Injected Date:"+date);
		int hour=0;
		
		hour=date.getHours();
		if(hour<12)
			return "Good Morning"+user;
		else if(hour<16)
			return "Good AfterNooon"+user;
		else if(hour<20)
			return "Good Evening"+user;
		else
			return "Good Night"+user;
	}

}
