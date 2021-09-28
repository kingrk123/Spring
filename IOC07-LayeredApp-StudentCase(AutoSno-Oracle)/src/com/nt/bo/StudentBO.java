package com.nt.bo;

public class StudentBO {
	
	private String sname;
	private int total;
	private int avg;
	private String result;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StudentBO [ sname=" + sname + ", total=" + total + ", avg=" + avg + ", result=" + result
				+ "]";
	}
}
