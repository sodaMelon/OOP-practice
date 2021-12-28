package com.account;

public class AccountTest {

	public static void main(String[] args) {
		int mode = 1; //0: 우리은행 , 1: KB은행
		IAccount bank;

		//generate new object
		if (mode == 0 ) {
			bank = new WRAccount();
		}
		else bank = new KBAccount();
		
		//biz logic
		bank.deposit(10000);
		//형변환 해서 출력가능 ((kbaccount)bank)).print();
		try {
			bank.withdraw(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(bank.getBalance());

	}

}
