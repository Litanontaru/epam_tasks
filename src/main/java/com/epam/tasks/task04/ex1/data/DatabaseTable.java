package com.epam.tasks.task04.ex1.data;

import com.epam.tasks.task04.ex1.Cache;
import com.epam.tasks.task04.ex1.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
@CacheDeclaration(name = "CacheDBTable")
public class DatabaseTable implements Cache {
    private static DatabaseTable instance;
    private Map<Integer, String> data = new HashMap<>();

    public static DatabaseTable getInstance(){
        if (instance == null){
            instance = new DatabaseTable();
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
