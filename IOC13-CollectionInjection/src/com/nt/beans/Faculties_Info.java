package com.nt.beans;

import java.util.Properties;

public class Faculties_Info {
	private Properties facutySubjects;

	public void setFacutySubjects(Properties facutySubjects) {
		this.facutySubjects = facutySubjects;
	}

	@Override
	public String toString() {
		return "Faculties_Info [facutySubjects=" + facutySubjects + "]";
	}
}
