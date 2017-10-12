package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.caches.CacheDBTable;
import com.epam.tasks.task04.ex1.caches.CacheWS1;
import com.epam.tasks.task04.ex1.caches.CacheWS2;
import com.epam.tasks.task04.ex1.data.DatabaseTable;
import com.epam.tasks.task04.ex1.data.WebServer1;
import com.epam.tasks.task04.ex1.data.WebServer2;

import java.util.Random;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillCaches {
    private static Random random = new Random(System.currentTimeMillis());

    public static void fillCacheDBTable(int elementsCount){
        DatabaseTable databaseTable = DatabaseTable.getInstance();
        CacheDBTable cacheDBTable = CacheDBTable.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(databaseTable.getSize());
            cacheDBTable.cache.put(randomIndex, databaseTable.get(randomIndex));
        }

    }

    public static void fillCacheWS1(int elementsCount){
        WebServer1 webServer1 = WebServer1.getInstance();
        CacheWS1 cacheWS1 = CacheWS1.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServer1.getSize());
            cacheWS1.cache.put(randomIndex, webServer1.get(randomIndex));
        }

    }

    public static void fillCacheWS2(int elementsCount){
        WebServer2 webServer2 = WebServer2.getInstance();
        CacheWS2 cacheWS2 = CacheWS2.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServer2.getSize());
            cacheWS2.cache.put(randomIndex, webServer2.get(randomIndex));
        }

    }
}
