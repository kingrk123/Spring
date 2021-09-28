package com.nt.beans;

public class DTDC implements Courier {
	public DTDC() {
		System.out.println("DTDC():0 Param Constructor");
	}

	@Override
	public String deliver(int orderid) {
		return "DTDC is ready to deliver products of "+orderid;
	}

}
