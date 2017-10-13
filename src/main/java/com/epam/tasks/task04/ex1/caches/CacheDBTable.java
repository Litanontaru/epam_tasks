package com.epam.tasks.task04.ex1.caches;

import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class CacheDBTable {
    private static CacheDBTable instance;
    public Map<Integer, String> cache = new HashMap<>();

    private CacheDBTable(){}

    public static CacheDBTable getInstance(){
        if (instance == null){
            instance = new CacheDBTable();
        }
        return instance;
    }
}
