package com.epam.tasks.task04.ex1.cacheusers;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class DatabaseTable {
    private Map<Integer, String> data = new HashMap<>();

    @InjectCache(name = "CacheDBTable")
    public Map<Integer, String> cache;

    public void put(Integer key, String value){
        data.put(key, value);
    }

    public String get(Integer key){
        return data.get(key);
    }

    public int getSize(){
        return data.size();
    }

    public void printCache(){
        System.out.println("DatabaseTable");
        System.out.println("Cache name = \"CacheDBTable\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("Cache: ");
        for (Map.Entry pair : cache.entrySet()){
            System.out.println("Key: " + pair.getKey() + ", value: " + pair.getValue());
        }
    }
}
