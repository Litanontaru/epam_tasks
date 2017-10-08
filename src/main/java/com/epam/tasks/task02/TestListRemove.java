package com.epam.tasks.task02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 05.10.2017.
 */
public class TestListRemove {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 8, 3, 4, 5);

        Predicate<Integer> predicate = (i) -> i % 2 == 0;

        List<Integer> list2 = new PredicateList<>(list, predicate);
        printElements(list2);
        //1, 2, 8, 3, 4, 5

        list2.remove(0); // value: '1'. has been removed
        list2.remove(1); // value: '2'. hasn't been removed

        System.out.println();
        printElements(list2);
        //2, 8, 3, 4, 5

        list2.remove(new Object()); // some object. hasn't been removed
        list2.remove(list2.get(3)); // value: '4'. hasn't been removed
        list2.remove(list2.get(4)); // value: '5'. has been removed

        System.out.println();
        printElements(list2);
        //2, 8, 3, 4
    }

    private static void printElements(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Size: " + list.size());
    }

}
