package com.account;

public class KBAccount extends Log implements IAccount{

    private int balance;

    public int withdraw(int value) throws Exception {
        log("Phase: Withdraw " + value);
        if (balance > value) {
            balance -= value;
            return balance;
        }
        log("error: not enough money");
        throw new Exception("ERROR");    }

    public void deposit(int value) {
        balance += value;
    }

    public int getBalance() {
        return balance;
    }

    public void print(){
        super.print();
        System.out.println("잔고:" + balance);
    }


}
