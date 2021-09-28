package com.nt.beans;

import java.util.Date;
import java.util.List;

public class College {
	private List<String> student;
	private List<Date> dates;
	
	public void setStudent(List<String> student) {
		this.student = student;
	}
	public void setDates(List<Date> dates) {
		System.out.println(dates.getClass());
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "College [student=" + student + ", dates=" + dates + "]";
	}
}
