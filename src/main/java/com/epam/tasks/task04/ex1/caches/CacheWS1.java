package com.epam.tasks.task04.ex1.caches;

import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheWS1")
public class CacheWS1 {
    private static CacheWS1 instance;
    public Map<Integer, String> cache = new HashMap<>();

    public static CacheWS1 getInstance(){
        if (instance == null){
            instance = new CacheWS1();
        }
        return instance;
    }
}
