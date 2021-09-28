package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class Personal_Info {
	private Set<Long> PhoneNo;
	private Set<Date> dates;
	
	
	public void setPhoneNo(Set<Long> phoneNo) {
		PhoneNo = phoneNo;
	}
	public void setDates(Set<Date> dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "Personal_Info [PhoneNo=" + PhoneNo + ", dates=" + dates + "]";
	}
}
