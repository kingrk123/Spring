package com.nt.beans;

public class A {
	private B b;

	public void setB(B b) {
		System.out.println("From Class A:");
		this.b = b;
	}

	@Override
	public String toString() {
		return "A ........";
	}

}
