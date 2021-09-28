package com.nt.beans;

public class LoanDetails {
	private int loanId;
	private String loanType;
	private String customer;
	
	public LoanDetails() {
		System.out.println("LoanDetails::0-Param Constructor");
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "LoanDetails [loanId=" + loanId + ", loanType=" + loanType + ", customer=" + customer + "]";
	}
	
}
