package com.nt.command;

public class PatientDetailsInfoCommand {
	private String pname;
	private String paddrs;
	private String problem;
	private String doctor;
	
	public PatientDetailsInfoCommand() {
		System.out.println("PatientDetailsInfoCommand::0-param constructor");
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddrs() {
		return paddrs;
	}

	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

}
