package com.nt.beans;

public class BankLoanApprover {
	private LoanDetails details;
	
	public BankLoanApprover() {
		System.out.println("BankLoanApprover::0-ParamConstructor");
	}

	public void setDetails(LoanDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "BankLoanApprover [details=" + details + "]";
	}
	public String approveLoan() {
		if(details.getLoanType().equals("two-wheeler")) {
		return "Loan is approved";
	}else {
		return "Loan is rejected";
	}
	}
}
