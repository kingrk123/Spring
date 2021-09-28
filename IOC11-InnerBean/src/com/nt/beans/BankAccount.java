package com.nt.beans;

public class BankAccount {	
	private Long Accno;
	private String HolderName;
	private float balance;
	private Boolean NRIBankingEnabled;
	
	public BankAccount() {
		System.out.println("BankAccount ::0-Param Constructor");
	}

	public void setAccno(Long accno) {
		Accno = accno;
	}

	public void setHolderName(String holderName) {
		HolderName = holderName;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void setNRIBankingEnabled(Boolean nRIBankingEnabled) {
		NRIBankingEnabled = nRIBankingEnabled;
	}
	public float  showBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "BankAccount [Accno=" + Accno + ", HolderName=" + HolderName + ", balance=" + balance
				+ ", NRIBankingEnabled=" + NRIBankingEnabled + "]";
	}

}
