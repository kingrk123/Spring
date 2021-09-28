package com.nt.beans;
import java.lang.String;
import java.util.Date;

public class WishMessageGenerator {
	private Date date;
	//0- Param Constructor
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator()::0-Param Constructor");
	}
	//setter For Date
	public void setDate(Date date) {
		this.date = date;
	}

	public String Generater(String user) {
		int hour =0;
		hour=date.getHours();//24 hours
		if(hour<=12)
			return "Good Morning"+user;
		else if (hour<=16)
			return "Good AfterNoon"+user;
		else if(hour<=20)
			return "Good Evening"+user;
		else
			return "Good Night"+user;
	}
}
