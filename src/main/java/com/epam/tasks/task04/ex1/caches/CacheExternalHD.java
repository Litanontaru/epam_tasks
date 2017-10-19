package com.epam.tasks.task04.ex1.caches;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.annotations.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheExternalHD")
public class CacheExternalHD implements Cache {
    private static CacheExternalHD instance;
    public Map<Integer, String> cache = new HashMap<>();

    private CacheExternalHD(){}

    @Override
    public void put(Integer key, String value) {
        cache.put(key, value);
    }

    @Override
    public String get(Integer key) {
        return cache.get(key);
    }

    public static CacheExternalHD getInstance(){
        if (instance == null){
            instance = new CacheExternalHD();
        }
        return instance;
    }
}
