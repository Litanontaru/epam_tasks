package com.epam.tasks.task05.ex1.unsynchr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komarov Vasiliy on 16.10.2017.
 */
public class Demonstration {
    public static void start(){
        Bank bank = new Bank(1000000);

        List<BankUser> bankUsers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            bankUsers.add(new BankUser(bank, 100));
        }

        for (BankUser user : bankUsers){
            new Thread(user).start();
        }
    }
}
