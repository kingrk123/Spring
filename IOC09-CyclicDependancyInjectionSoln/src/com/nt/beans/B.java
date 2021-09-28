package com.nt.beans;

public class B {
	private A a;

	public void setA(A a) {
		System.out.println("From Class B:");
		this.a = a;
	}

	@Override
	public String toString() {
		return "B ........";
	}
	
}
