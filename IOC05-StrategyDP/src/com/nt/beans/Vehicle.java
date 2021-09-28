package com.nt.beans;

public class Vehicle {
	private Engine engine;
	
	public Vehicle() {
		System.out.println("Vehicle.Vehicle()- 0 Param Constructor");
	}

	public void setEngine(Engine engine) {
		System.out.println("Vehicle.setEngine()");
		this.engine = engine;
	}
	public  void  journery(String startPlace,String destPlace) {
		 engine.start();
		 System.out.println("Viechle is moving......");
		 engine.stop();
		 System.out.println(startPlace+"  to  "+destPlace +" jounery Completed");
	}
}
