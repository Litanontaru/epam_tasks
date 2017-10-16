package com.epam.tasks.task05.ex1.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class Bank {
    public Semaphore semaphore = new Semaphore(1);

    private int moneyAmount;

    public Bank(int moneyAmount){
        this.moneyAmount = moneyAmount;
    }

    public void getMoney(int money){
        if (!hasMoney(money)){
            throw new IllegalArgumentException("Credit limit is exceeded");
        }
        moneyAmount -= money;
    }

    public boolean hasMoney(int money) {
        return moneyAmount >= money;
    }
}
