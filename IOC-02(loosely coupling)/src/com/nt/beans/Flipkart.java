package com.nt.beans;

import java.util.Random;

public class Flipkart {
	private Courier courier;
	public Flipkart() {
		System.out.println("Flipkart:0-param constructor");
	}
	//setter methos for setter injection
	public void setCourier(Courier courier) {
		System.out.println("Flipkart:setCourier(-)");
		this.courier=courier;
	}
	public String purchase(String items[]) {
		//generate order id
		Random rad = new Random();
		int orderid = rad .nextInt(700000);
		//deliver order
		String status = courier.deliver(orderid);
		return status +" Bill Amt for order id "+orderid +" is 700000";
	}//method
}//class
