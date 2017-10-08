package com.epam.tasks.task02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 05.10.2017.
 */
public class TestListAdd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 8, 3, 4, 5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        List<Integer> list2 = new PredicateList<>(list, predicate);

        printElements(list2);
        System.out.println();

        checkAdd(list2.add(5));
        checkAdd(list2.add(8));

        System.out.println();
        printElements(list2);
    }

    private static void printElements(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Size: " + list.size());
    }

    private static void checkAdd(boolean resultAdd){
        if (resultAdd) System.out.println("Element has been added");
        else System.out.println("Element hasn't been added");
    }
}
