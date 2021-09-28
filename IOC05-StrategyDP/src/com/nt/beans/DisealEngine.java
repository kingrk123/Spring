package com.nt.beans;

public class DisealEngine implements Engine {
	public DisealEngine() {
		System.out.println("DisealEngine.DisealEngine()-0 Param Constructor");
	}
	@Override
	public void start() {
		System.out.println("DisealEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("DisealEngine.stop()");

	}

}
