package com.nt.beans;

public class CNGEngine implements Engine {
	public CNGEngine() {
		System.out.println("CNGEngine.CNGEngine()-0 Param Constructor");
	}
	@Override
	public void start() {
		System.out.println("CNGEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop()");

	}

}
