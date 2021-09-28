package com.nt.beans;

public class Employee {
	private int eno;
	private String ename;
	private int edeptno;
	private int salary;
	private String edesignation;
	
	public Employee(int eno,String ename,int edeptno,int salary,String edesignation) {
		System.out.println("5-Param Costructor Employee()");
		this.eno=eno;
		this.ename=ename;
		this.edeptno=edeptno;
		this.salary=salary;
		this.edesignation=edesignation;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", edeptno=" + edeptno + ", salary=" + salary
				+ ", edesignation=" + edesignation + "]";
	}

}
