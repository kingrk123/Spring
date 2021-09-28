package com.nt.beans;

import org.springframework.beans.factory.BeanFactory;

public class ProffestionalCricketer {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public void bowling() {
		System.out.println(name+" Cricketer is Bowling");
	}
	public void fielding() {
		System.out.println(name+" Cricketer is Fielding");
	}
	public void batting(BeanFactory factory) {
		CricketBat bat=null;
		bat=factory.getBean(CricketBat.class);
		System.out.println(name+" Cricketer is Batting");
		bat.scoreRun();
	}
}
