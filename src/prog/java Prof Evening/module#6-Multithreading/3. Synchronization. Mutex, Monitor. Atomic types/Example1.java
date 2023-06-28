// пример, в котором можно иногда пронаблюдать проблему с конфликтом доступа к обновлению баланса
// можно продемонстрировать и пронаблюдать, что иногда будет встречаться баланс не 2000, а 1000
// для иллюстрации я складываю все балансы в set и вывожу её в консоль


import java.util.HashSet;
import java.util.Set;

public class Example1 {
    public static void main(String[] args) throws Exception {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setBalance(0);

            TestThread thread1 = new TestThread();
            TestThread thread2 = new TestThread();

            thread1.setBankAccount(bankAccount);
            thread2.setBankAccount(bankAccount);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            set.add(bankAccount.getBalance());
        }

        System.out.println(set);
    }
}

class TestThread extends Thread {

    BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        this.bankAccount.increaseBalance();
    }
}

class BankAccount {
    private int balance;

    public void increaseBalance() {
        balance = balance + 1000;
    }

//    для решения проблемы:
//    public synchronized void increaseBalance() {
//        balance = balance + 1000;
//    }
//    или
//    public void increaseBalance() {
//        synchronized (this) {
//            balance = balance + 1000;
//        }
//    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}