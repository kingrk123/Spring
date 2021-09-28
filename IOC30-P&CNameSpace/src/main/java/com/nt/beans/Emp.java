package com.nt.beans;

public class Emp {
	private int eno;
	private String ename;
	private Dept dept;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Dept [eno=" + eno + ", ename=" + ename + ", dept=" + dept + "]";
	}

}
