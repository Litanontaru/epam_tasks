package com.epam.tasks.task04.ex1.tests;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class TestClass2 {
    @InjectCache(name = "CacheWS")
    public Map<Integer, String> webServer;

    public void printCache(){
        System.out.println("Test2");
        System.out.println("Cache name = \"CacheWS\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("webServer: ");
        for (Map.Entry pair : webServer.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
