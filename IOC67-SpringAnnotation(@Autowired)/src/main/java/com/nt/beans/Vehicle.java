package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Vehicle {

	@Autowired
	@Qualifier("e")
	private Engine engine;
	
	public Vehicle(Engine engine) {
		System.out.println("1-Param Constructor");
		this.engine = engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Vehicle [engine=" + engine + "]";
	}
	
}
