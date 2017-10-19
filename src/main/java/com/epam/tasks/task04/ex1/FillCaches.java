package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.caches.CacheDBTable;
import com.epam.tasks.task04.ex1.caches.CacheWS;
import com.epam.tasks.task04.ex1.caches.CacheExternalHD;
import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer;
import com.epam.tasks.task04.ex1.cacheusers.WebServerInheritor;

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

    public static void fillCacheWS1(WebServer webServer, int elementsCount){
        CacheWS cacheWS = CacheWS.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServer.getSize());
            cacheWS.put(randomIndex, webServer.get(randomIndex));
        }

    }

    public static void fillCacheWS2(WebServerInheritor webServerInheritor, int elementsCount){
        CacheExternalHD cacheExternalHD = CacheExternalHD.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            int randomIndex = random.nextInt(webServerInheritor.getSize());
            cacheExternalHD.put(randomIndex, webServerInheritor.get(randomIndex));
        }

    }
}
