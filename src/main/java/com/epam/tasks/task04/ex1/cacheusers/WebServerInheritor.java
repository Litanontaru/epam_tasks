package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.annotations.InjectCache;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class WebServerInheritor extends WebServer {
    @InjectCache(name = "CacheWS")
    private Cache cache;

    public void printCache(int key){
        System.out.print("Cache (current class): ");
        System.out.println("Key: " + key + ", value: " + cache.get(key));
        System.out.print("Cache (super class): ");
        System.out.println("Key: " + key + ", value: " + super.cache.get(key));
    }
}
