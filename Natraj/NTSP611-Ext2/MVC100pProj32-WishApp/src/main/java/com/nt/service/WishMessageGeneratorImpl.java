package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wMsg")
public class WishMessageGeneratorImpl implements WishMessageGenerator {

	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		//System Date
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate message
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
	}//method
}//class
