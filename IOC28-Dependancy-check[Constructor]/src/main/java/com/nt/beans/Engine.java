package com.nt.beans;

public class Engine {
	private int id;
	private Engine engine;
	public void setId(int id) {
		this.id = id;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", engine=" + engine + "]";
	}
}
