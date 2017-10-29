package com.epam.tasks.task05.ex1.concurrent;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class BankUser implements Runnable{
    //поле может быть final
    private Bank bank;
    //поле может быть final
    private int sizeOfOneTransaction;

    public BankUser(Bank bank, int sizeOfOneTransaction){
        this.bank = bank;
        this.sizeOfOneTransaction = sizeOfOneTransaction;
    }

    @Override
    public void run() {
        try {
            //в while стоит условие, которое получает незащищённый конкурентный доступ. Это ошибка.
            while (bank.hasMoney(sizeOfOneTransaction)){
                bank.semaphore.acquire();
                if (bank.hasMoney(sizeOfOneTransaction)) {
                    bank.getMoney(sizeOfOneTransaction);
                }
                //обычно такие операции, как release делают в секции finally, чтобы гарантированно отпускать
                bank.semaphore.release();
            }
        }
        // catch пишется на той же строчке что из "}" выше, если конечно ты не контрибьютишь в Apache Ignite
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}