package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageGeneratorServiceImpl implements WishMessageGeneratorService {

	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<12)
			  return "Good Morning..1";
		else if(hour<16)
			return "Good Afternoon..1";
		else if(hour<20)
			return "Good Evening..1";
		else
			return "Good Night..1";
	}

}
