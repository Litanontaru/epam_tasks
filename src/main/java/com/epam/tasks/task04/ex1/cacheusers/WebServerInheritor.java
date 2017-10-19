package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class WebServerInheritor extends WebServer {
    private Map<Integer, String> data = new HashMap<>();

    @InjectCache(name = "CacheExternalHD")
    private Map<Integer, String> cache;

    public void put(Integer key, String value){
        data.put(key, value);
    }

    public String get(Integer key){
        return data.get(key);
    }

    public int getSize(){
        return data.size();
    }

    public void printCache(){
        System.out.println("WebServerInheritor");
        System.out.println("Cache name = \"CacheExternalHD\"");
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
