package com.epam.tasks.task05.ex2.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
//Во всём классе кое-где нехватает пробелов
public class Philosopher implements Runnable{
    private static final Semaphore SEMAPHORE = new Semaphore(4);
    private String name;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void startEating() throws InterruptedException{
        //Непонятна роль SEMAPHORE здесь. Самых synchronized уже достаточно.
        SEMAPHORE.acquire();
        synchronized (leftFork){
            synchronized (rightFork){
                System.out.println(name + " eating");
                //неясен смысл sleep(0)
                Thread.sleep(0);
            }
        }
        SEMAPHORE.release();
    }

    private void startThinking() throws InterruptedException{
        System.out.println(name + " thinking");
        //неясен смысл sleep(0)
        Thread.sleep(0);
    }

    @Override
    public void run() {
        while (true){
            try{
                startThinking();
                startEating();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
