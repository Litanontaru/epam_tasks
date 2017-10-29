package com.epam.tasks.task05.ex1.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
//в коде кое-где не хватает пробелов
public class Bank {
    //поле может быть final
    //Нарушение приципов инкапсуляции и принципа "Open/Closed" из SOLID
    public Semaphore semaphore = new Semaphore(1);

    //В будущем стоит изучить необходимость использования volatile для подобных переменных
    //В реальном продакшене без volatile это не будет работать
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
