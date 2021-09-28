package com.nt.Bean;

import java.util.Date;

public class WishMssgGenerator {
	
	private String name;
	private Date date;
	
	public void setName(String name) {
		System.out.println("WishMssgGenerator setName");
		this.name =name;
	}
	public void setDate(Date date) {
		System.out.println("WishMssgGenerator setDate");
	}
	
	public int Mul(int a, int b) {
		return a*b;
	}
	
	public String WishMessageGenerator() {
		return "Good Morning "+name+ ".."+date;
 
		
	}

}
