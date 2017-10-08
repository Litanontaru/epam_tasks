package com.epam.tasks.task02;

import com.epam.tasks.task03.Convertible;
import com.epam.tasks.task03.Reducible;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 07.10.2017.
 */
public class TestMapReduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(3);
        list.add(4);
        list.add(5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        PredicateList<Integer> predicateList = new PredicateList<>(list, predicate);

        List<String> newList = predicateList.map(new Convertible<Integer, String>() {
            @Override
            public String map(Integer e){
                return "number_" + e;
            }
        });

        for (String data : newList){
            System.out.println(data);
        }

        System.out.println("-----------------");

        int resultReduce = predicateList.reduce(new Reducible<Integer>() {
            @Override
            public Integer reduce(Integer element1, Integer element2) {
                return element1 + element2;
            }
        });

        System.out.println(resultReduce);
    }
}
