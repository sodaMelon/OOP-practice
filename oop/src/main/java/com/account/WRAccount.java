package com.account;

public class WRAccount implements IAccount{

	private int balance;
	public int withdraw(int value) throws Exception {
		if (balance > value) {
			balance -= value;
			return balance;
		}
		throw new Exception("ERROR");
	}

	public void deposit(int value) {
		balance += value*1.1f;
	}

	public int getBalance() {
		return balance;
	}



}
