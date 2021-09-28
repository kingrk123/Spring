package com.nt.beans;

public class PetrolEngine implements Engine {
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine()- 0 Param Constructor");
	}
	@Override
	public void start() {
		System.out.println("PetrolEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()");

	}

}
