package com.epam.tasks.task04.ex1.tests;

import com.epam.tasks.task04.ex1.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class TestClass1 {
    @InjectCache(name = "CacheDBTable")
    public Map<Integer, String> dbTable;

    public void printCache(){
        System.out.println("Test1");
        System.out.println("Cache name = \"CacheDBTable\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("dbTable: ");
        for (Map.Entry pair : dbTable.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
