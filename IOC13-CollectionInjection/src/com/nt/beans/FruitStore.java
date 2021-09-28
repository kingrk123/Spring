package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FruitStore {
	private Map<String, String> fruits;
	private Map<String, Date> specialdates;
	private Map<Date, String> specialdates1;
	
	public void setFruits(Map<String, String> fruits) {
		this.fruits = fruits;
	}
	public void setSpecialdates(Map<String, Date> specialdates) {
		this.specialdates = specialdates;
	}
	public void setSpecialdates1(Map<Date, String> specialdates1) {
		this.specialdates1 = specialdates1;
	}
	@Override
	public String toString() {
		return "FruitStore [fruits=" + fruits + ", specialdates=" + specialdates + ", specialdates1=" + specialdates1
				+ "]";
	}
}
