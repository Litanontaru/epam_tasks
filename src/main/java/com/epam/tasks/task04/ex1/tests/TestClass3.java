package com.epam.tasks.task04.ex1.tests;

import com.epam.tasks.task04.ex1.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class TestClass3 extends TestClass2{
    @InjectCache(name = "CacheWS1")
    private Map<Integer, String> webServer_ext;

    public void printCache(){
        System.out.println("Test3");
        System.out.println("Cache name = \"CacheWS1\"");
        System.out.println("Field - private");
        System.out.println("Super class - TestClass2");
        System.out.println("---------------------");
        System.out.println("webServer_ext (current class): ");
        for (Map.Entry pair : webServer_ext.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
        System.out.println("webServer (super class): ");
        for (Map.Entry pair : webServer.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
