package com.epam.tasks.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 05.10.2017.
 */
public class TestListRemove {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(3);
        list.add(4);
        list.add(5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        List<Integer> list2 = new PredicateList<>(list, predicate);
        list2.remove(0); // successful
        list2.remove(1); // exception
    }
}
