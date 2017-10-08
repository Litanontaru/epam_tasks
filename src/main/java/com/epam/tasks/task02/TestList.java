package com.epam.tasks.task02;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 01.10.2017.
 */
public class TestList {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 8, 3, 4, 5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        List<Integer> list2 = new PredicateList<>(list, predicate);
        Iterator<Integer> itr = list2.iterator();
        while (itr.hasNext()){
            itr.hasNext(); // Повторный вызов hasNext() не вызывает потерю данных
            itr.hasNext(); // Повторный вызов hasNext() не вызывает потерю данных
            Integer data = itr.next();
            System.out.println(data);
        }

        System.out.println("-----------------");

        ListIterator<Integer> itr2 = list2.listIterator(list2.size());
        while (itr2.hasPrevious()){
            itr2.hasPrevious(); // Повторный вызов hasPrevious() не вызывает потерю данных
            itr2.hasPrevious(); // Повторный вызов hasPrevious() не вызывает потерю данных
            Integer data = itr2.previous();
            System.out.println(data);
        }
    }
}
