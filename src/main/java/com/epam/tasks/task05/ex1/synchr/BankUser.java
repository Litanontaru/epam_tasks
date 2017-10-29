package com.epam.tasks.task05.ex1.synchr;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class BankUser implements Runnable{
    //поле должно быть final
    private Bank bank;
    //поле может быть final
    private int sizeOfOneTransaction;

    public BankUser(Bank bank, int sizeOfOneTransaction){
        this.bank = bank;
        this.sizeOfOneTransaction = sizeOfOneTransaction;
    }

    @Override
    public void run() {
        //в while стоит условие, которое получает незащищённый конкурентный доступ. Это ошибка.
        while (bank.hasMoney(sizeOfOneTransaction)) {
                synchronized (bank) {
                    if (bank.hasMoney(sizeOfOneTransaction)) {
                        bank.getMoney(sizeOfOneTransaction);
                    }
                }
            }
    }
}