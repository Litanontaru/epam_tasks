package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.caches.CacheDBTable;
import com.epam.tasks.task04.ex1.caches.CacheWS1;
import com.epam.tasks.task04.ex1.caches.CacheWS2;
import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer1;
import com.epam.tasks.task04.ex1.cacheusers.WebServer2;

import java.util.Random;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillCaches {
    private static Random random = new Random(System.currentTimeMillis());

    public static void fillCacheDBTable(DatabaseTable databaseTable, int elementsCount){
        CacheDBTable cacheDBTable = CacheDBTable.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(databaseTable.getSize());
            cacheDBTable.put(randomIndex, databaseTable.get(randomIndex));
        }

    }

    public static void fillCacheWS1(WebServer1 webServer1, int elementsCount){
        CacheWS1 cacheWS1 = CacheWS1.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServer1.getSize());
            cacheWS1.put(randomIndex, webServer1.get(randomIndex));
        }

    }

    public static void fillCacheWS2(WebServer2 webServer2, int elementsCount){
        CacheWS2 cacheWS2 = CacheWS2.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServer2.getSize());
            cacheWS2.put(randomIndex, webServer2.get(randomIndex));
        }

    }
}
