package com.nt.beans;

import java.util.Date;

public class Personal_Info {
	private int aid;
	private String name;
	private Date doj;
	
	public Personal_Info(int aid, String name, Date doj) {
		
		System.out.println("Personal_Info()::3-Param Constructor");
		this.aid = aid;
		this.name = name;
		this.doj = doj;
		
	}

	@Override
	public String toString() {
		return "Personal_Info [aid=" + aid + ", name=" + name + ", doj=" + doj + "]";
	}
}
