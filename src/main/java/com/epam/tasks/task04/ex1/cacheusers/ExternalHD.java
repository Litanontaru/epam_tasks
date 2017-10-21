package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.annotations.InjectCache;

/**
 * Created by Komarov Vasiliy on 19.10.2017.
 */
public class ExternalHD {
    @InjectCache(name = "CacheExternalHD")
    public Cache cache;

    public void printCache(int key){
        System.out.println("Key: " + key + ", value: " + cache.get(key));
    }
}
