package com.epam.tasks.task03;

import com.epam.tasks.task02.PredicateList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 07.10.2017.
 */
public class TestMapReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 8, 3, 4, 5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        PredicateList<Integer> predicateList = new PredicateList<>(list, predicate);

        System.out.println("The source list:");
        printElements(predicateList);

        List<String> newList = predicateList.map(new Convertible<Integer, String>() {
            @Override
            public String map(Integer e){
                return "number_" + e;
            }
        });

        System.out.println();
        System.out.println("The result of map():");
        printElements(newList);

        int resultReduce = predicateList.reduce(new Reducible<Integer>() {
            @Override
            public Integer reduce(Integer element1, Integer element2) {
                return element1 + element2;
            }
        });

        System.out.println();
        System.out.println("The result of reduce():");
        System.out.println(resultReduce);
    }

    private static void printElements(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
