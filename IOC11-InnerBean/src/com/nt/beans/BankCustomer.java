package com.nt.beans;

public class BankCustomer {
	private BankAccount account;
	private String bankName;
	
	public BankCustomer(BankAccount account,String bankName) {
		System.out.println("2-ParamConstructor");
		this.account = account;
		this.bankName = bankName;

	}
	public float getBalance() {
		return account.showBalance();
	}
	@Override
	public String toString() {
		return "BankCustomer [account=" + account + ", bankName=" + bankName + "]";
	}
}
