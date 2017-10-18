package com.epam.tasks.task05.ex2.synchr;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class Watcher {
    private Set<Fork> usedForks;

    public Watcher() {
        usedForks = new HashSet<>();
    }

    public void requestForEating(Philosopher philosopher) throws InterruptedException{
        synchronized (usedForks){
            while (usedForks.contains(philosopher.getLeftFork()) || usedForks.contains(philosopher.getRightFork())){
                usedForks.wait();
            }
            usedForks.add(philosopher.getLeftFork());
            usedForks.add(philosopher.getRightFork());
        }
        philosopher.startEating();
        synchronized (usedForks){
            usedForks.remove(philosopher.getLeftFork());
            usedForks.remove(philosopher.getRightFork());
            usedForks.notifyAll();
        }
    }
}
