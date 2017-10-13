package com.epam.tasks.task04.ex1.data;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheWS2")
public class WebServer2 implements Cache {
    private static WebServer2 instance;
    private Map<Integer, String> data = new HashMap<>();

    private WebServer2(){}

    public static WebServer2 getInstance(){
        if (instance == null){
            instance = new WebServer2();
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
