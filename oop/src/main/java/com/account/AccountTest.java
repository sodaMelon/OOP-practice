package com.account;

public class AccountTest {

	public static void main(String[] args) throws Exception {
		int mode = 1; //0: 우리은행 , 1: KB은행
		String baseClass="com.account.KBAccount"; //리플렉션 (절대경로 사용)
		IAccount bank;

		Class cls = Class.forName(baseClass);
		bank =  (IAccount) cls.newInstance();

		//generate new object
		if (mode == 0 ) {
			bank = new WRAccount();
		}
		else bank = new KBAccount();
		
		//biz logic
		bank.deposit(10000);

		((KBAccount) bank).print();
		try {
			bank.withdraw(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(bank.getBalance());

	}

}
