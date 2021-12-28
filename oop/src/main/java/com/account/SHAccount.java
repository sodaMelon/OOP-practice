package com.account;

public class SHAccount implements IAccount{
    private int balance;

    public int withdraw(int value) throws Exception {
        if ( balance >  value) {
            balance -= value;
        } else {
            throw new Exception("잔고부족");
        }
        return  balance;
    }

    public void deposit(int value) {
        balance += value * 1.1;
    }

    public int getBalance() {
        return balance;
    }
}
