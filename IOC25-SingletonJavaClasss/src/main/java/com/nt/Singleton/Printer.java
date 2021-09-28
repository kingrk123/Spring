package com.nt.Singleton;

public class Printer {
	private static Printer INSTANCE;
	
	public Printer() {
		System.out.println("Printer::0-Param Constructor");
	}
	public static Printer getInstance() {
		if(INSTANCE==null)
			INSTANCE=new Printer();
		return INSTANCE;
	}
}
