package com.epam.tasks.task04.ex1;

/**
 * Created by Komarov Vasiliy on 09.10.2017.
 */
public interface Cache {
    void put(Integer key, String value);
    String get(Integer key);
}
