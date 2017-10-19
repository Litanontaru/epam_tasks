package com.epam.tasks.task04.ex1.caches;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.annotations.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheWS2")
public class CacheWS2 implements Cache {
    private static CacheWS2 instance;
    public Map<Integer, String> cache = new HashMap<>();

    private CacheWS2(){}

    @Override
    public void put(Integer key, String value) {
        cache.put(key, value);
    }

    @Override
    public String get(Integer key) {
        return cache.get(key);
    }

    public static CacheWS2 getInstance(){
        if (instance == null){
            instance = new CacheWS2();
        }
        return instance;
    }
}
