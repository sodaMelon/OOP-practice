public class MiniBank {
    public static void main(String[] args) { //메인에 throw 발생하면 종료기때문에 여기 붙여도 되간함
        Account acc = new Account();
        acc.deposit(1000);
        try {
            acc.withrawl(200);
        } catch (Exception e) {
            e.printStackTrace();
        } // 예외 처리 연습

        WRAccount bank1 = new WRAccount();
        bank1.deposit(1000);
        System.out.println(bank1.getBalance());

        KBAccount bank2 = new KBAccount();
        bank2.deposit(1000);
        System.out.println(bank2.getBalance());
    }
}

class Account implements IAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        balance += value;
    }

    public int withrawl(int value) throws Exception {
        if (balance > value) {
            balance -= value;
            return balance;
        }
        throw new Exception("예외 발생 ㅇㅅㅇ;");
    }
}

interface IAccount {
    public int withrawl(int value) throws Exception;
    public void deposit(int value);
    public int getBalance();
}

class WRAccount extends Account{ //상속연습 준비

}

class KBAccount{ //상속연습 준비2

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        balance += value;
    }

    public void withdraw(int value) {
        balance -= value;
    }
}