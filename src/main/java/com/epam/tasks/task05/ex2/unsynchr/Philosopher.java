package com.epam.tasks.task05.ex2.unsynchr;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class Philosopher implements Runnable{
    private String name;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void startEating() throws InterruptedException{
        synchronized (leftFork){
            synchronized (rightFork){
                System.out.println(name + " eating");
                Thread.sleep(0);
            }
        }
    }

    private void startThinking() throws InterruptedException{
        System.out.println(name + " thinking");
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
