package com.epam.tasks.task04.ex1.data;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheWS1")
public class WebServer1 implements Cache {
    private static WebServer1 instance;
    private Map<Integer, String> data = new HashMap<>();

    public static WebServer1 getInstance(){
        if (instance == null){
            instance = new WebServer1();
        }
        return instance;
    }

    @Override
    public void put(Integer key, String value) {
        data.put(key, value);
    }

    @Override
    public String get(Integer key) {
        return data.get(key);
    }

    public int getSize(){
        return data.size();
    }
}
