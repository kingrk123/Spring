package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	private DTDC dtdc;
	private BlueDart dart;
	int orderNo = 0;
	public Flipkart() {
		System.out.println("0-Param Constructor:: ");
	}
	
	public Flipkart(BlueDart dart) {
		System.out.println("1-Param Constructor::");
		this.dart=dart;
	}

	public void setDtdc(DTDC dtdc) {
		System.out.println("Flipkart.setDtdc()::");
		this.dtdc = dtdc;
	}
	
	public String purchase(String items[]) {
		//generate id no.
		Random rad=new Random();
		int orderid= rad.nextInt(100000);
		//deliver order
		String status=dart.deliver(orderid);
		return null;
		
		
	}
	
	

}
