package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class WebServerInheritor extends WebServer {
    @InjectCache(name = "CacheWS")
    private Map<Integer, String> cache;

    public void printCache(){
        System.out.println("WebServerInheritor");
        System.out.println("Cache name = \"CacheWS\"");
        System.out.println("Field - private");
        System.out.println("Super class - WebServer");
        System.out.println("---------------------");
        System.out.println("Cache (current class): ");
        for (Map.Entry pair : cache.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
        System.out.println("Cache (super class): ");
        for (Map.Entry pair : super.cache.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
