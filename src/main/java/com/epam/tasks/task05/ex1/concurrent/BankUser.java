package com.epam.tasks.task05.ex1.concurrent;

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
        try {
            bank.semaphore.acquire();
            while (bank.hasMoney(sizeOfOneTransaction)){
                bank.getMoney(sizeOfOneTransaction);
            }
            bank.semaphore.release();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}