package com.epam.tasks.task04.ex1.caches;

import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class CacheWS2 {
    private static CacheWS2 instance;
    public Map<Integer, String> cache = new HashMap<>();

    private CacheWS2(){}

    public static CacheWS2 getInstance(){
        if (instance == null){
            instance = new CacheWS2();
        }
        return instance;
    }
}
