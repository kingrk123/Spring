package com.nt.beans;

import java.util.Arrays;

public class TourPlan {
	private String[] places;
	
	public void setPlaces(String[] places) {
		this.places = places;
	}

	public TourPlan() {
		System.out.println("TourPlan:0-Param Constructor");
	}

	@Override
	public String toString() {
		return "TourPlan [places=" + Arrays.toString(places) + "]";
	}
}
