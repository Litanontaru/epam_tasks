package com.epam.tasks.task04.ex1.tests;

import com.epam.tasks.task04.ex1.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class TestClass4 {
    @InjectCache(name = "CacheWS2")
    private Map<Integer, String> webServer;

    public void printCache(){
        System.out.println("Test4");
        System.out.println("Cache name = \"CacheWS2\"");
        System.out.println("Field - private");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("webServer: ");
        for (Map.Entry pair : webServer.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
