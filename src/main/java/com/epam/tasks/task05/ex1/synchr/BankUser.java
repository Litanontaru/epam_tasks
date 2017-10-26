package com.epam.tasks.task05.ex1.synchr;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class BankUser implements Runnable{
    private Bank bank;
    private int sizeOfOneTransaction;

    public BankUser(Bank bank, int sizeOfOneTransaction){
        this.bank = bank;
        this.sizeOfOneTransaction = sizeOfOneTransaction;
    }

    @Override
    public void run() {
            while (bank.hasMoney(sizeOfOneTransaction)) {
                synchronized (bank) {
                    if (bank.hasMoney(sizeOfOneTransaction)) {
                        bank.getMoney(sizeOfOneTransaction);
                    }
                }
            }
    }
}