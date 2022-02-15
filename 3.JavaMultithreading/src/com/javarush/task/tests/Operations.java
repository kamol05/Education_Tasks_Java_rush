package com.javarush.task.tests;

import javax.naming.InsufficientResourcesException;

public class Operations {

    static void transfer(Account a, Account b,int amount) throws Exception {
            if (a.getBalance() < amount){throw new Exception();
            }
            synchronized (a){
                Thread.sleep(1000);
                synchronized (b){
                a.withdraw(amount);
                b.deposit(amount);
            }
            }

    }

    public static void main(String[] args) throws Exception {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a,b,500);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }).start();

        transfer(b,a,300);


    }
}
