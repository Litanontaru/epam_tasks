package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.ExternalHD;
import com.epam.tasks.task04.ex1.cacheusers.WebServer;
import com.epam.tasks.task04.ex1.cacheusers.WebServerInheritor;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class Demonstration {
    public static final int SIZE_OF_TEST_CACHE = 5;

    public static void start(){
        try{
            createAndFillCaches();
            injectIntoDatabaseTable();
            injectIntoExternalHD();
            injectIntoWebServer();
            injectIntoWebServerInheritor();
            tryInjectIntoObject();
        }
        catch (InstantiationException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }

    }

    private static void createAndFillCaches() throws InstantiationException, IllegalAccessException{
        CacheInstances.initialize();
        CacheInstances.getMapCaches()
                .values()
                .forEach((cache) -> FillCaches.fillCache(cache, SIZE_OF_TEST_CACHE));
    }

    private static void injectIntoDatabaseTable(){
        DatabaseTable databaseTable = new DatabaseTable();

        Injector.injectCache(databaseTable);

        System.out.println("---------------------");
        System.out.println("DatabaseTable");
        System.out.println("Cache name = \"CacheDBTable\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("Cache: ");

        for (int i = 0; i < SIZE_OF_TEST_CACHE; i++) {
            databaseTable.printCache(i);
        }
    }

    private static void injectIntoExternalHD(){
        ExternalHD externalHD = new ExternalHD();

        Injector.injectCache(externalHD);

        System.out.println("---------------------");
        System.out.println("ExternalHD");
        System.out.println("Cache name = \"CacheExternalHD\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("Cache: ");

        for (int i = 0; i < SIZE_OF_TEST_CACHE; i++) {
            externalHD.printCache(i);
        }
    }

    private static void injectIntoWebServer(){
        WebServer webServer = new WebServer();

        Injector.injectCache(webServer);

        System.out.println("---------------------");
        System.out.println("WebServer");
        System.out.println("Cache name = \"CacheWS\"");
        System.out.println("Field - public");
        System.out.println("Super class - Object");
        System.out.println("---------------------");
        System.out.println("Cache: ");

        for (int i = 0; i < SIZE_OF_TEST_CACHE; i++) {
            webServer.printCache(i);
        }
    }

    private static void injectIntoWebServerInheritor(){
        WebServerInheritor webServerInheritor = new WebServerInheritor();

        Injector.injectCache(webServerInheritor);

        System.out.println("---------------------");
        System.out.println("WebServerInheritor");
        System.out.println("Cache name = \"CacheWS\"");
        System.out.println("Field - private");
        System.out.println("Super class - WebServer");
        System.out.println("---------------------");

        for (int i = 0; i < SIZE_OF_TEST_CACHE; i++) {
            webServerInheritor.printCache(i);
        }
    }

    private static void tryInjectIntoObject(){
        System.out.println("---------------------");
        System.out.println("Attempt to inject into object without the cache:");
        System.out.println("---------------------");
        try{
            Injector.injectCache(new Object());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
