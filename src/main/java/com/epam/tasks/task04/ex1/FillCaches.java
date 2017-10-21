package com.epam.tasks.task04.ex1;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillCaches {
    public static void fillCache(Cache cache, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            cache.put(i, cache.getClass().getSimpleName() + "_value_" + (i+1));
        }
    }
}
