package com.epam.tasks.task05.ex2.synchr;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
//Во всём классе кое-где нехватает пробелов
public class Demonstration{
    public static void start(){
        Fork[] forks = createFiveForks();
        Watcher watcher = new Watcher();
        Philosopher[] philosophers = createFivePhilosophers(forks, watcher);

        for (Philosopher philosopher : philosophers){
            new Thread(philosopher).start();
        }
    }

    private static Fork[] createFiveForks(){
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }
        return forks;
    }

    private static Philosopher[] createFivePhilosophers(Fork[] forks, Watcher watcher){
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher("Philosopher-" + (i+1)
                    , forks[i]
                    //Операцию ниже проще делать через оператор %
                    , i == forks.length-1 ? forks[0] : forks[i+1]
                    , watcher);
        }
        return philosophers;
    }
}
