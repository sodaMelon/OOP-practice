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

class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        balance += value;
    }

    public int withrawl(int value) throws Exception { //thorw를 여러개 바깥으로 던져줄수있어서 s붙음.? 아니 이건 객체라그렇고
        if (balance > value) {
            balance -= value;
            return balance;
        }
        throw new Exception("예외 발생 ㅇㅅㅇ;"); //여긴 명령문이라 그렇고가아니라?????()
    }

}


class WRAccount { //상속연습 준비

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        balance += value * 1.1f;
    }

    public void withdraw(int value) {
        balance -= value;
    }
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