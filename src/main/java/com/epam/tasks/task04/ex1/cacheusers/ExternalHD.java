package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.util.Map;

/**
 * Created by Komarov Vasiliy on 19.10.2017.
 */
public class ExternalHD {
    @InjectCache(name = "CacheExternalHD")
    public Map<Integer, String> cache;

    public void printCache(){
        System.out.println("ExternalHD");
        System.out.println("Cache name = \"CacheExternalHD\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("Cache: ");
        for (Map.Entry pair : cache.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
