package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer;
import com.epam.tasks.task04.ex1.cacheusers.WebServerInheritor;
import com.epam.tasks.task04.ex1.tests.*;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class Demonstration {
    public static void start(){
        DatabaseTable databaseTable = new DatabaseTable();
        WebServer webServer = new WebServer();
        WebServerInheritor webServerInheritor = new WebServerInheritor();

        FillDataProviders.fillDatabaseTable(databaseTable, 1000);
        FillDataProviders.fillWebServer1(webServer, 1000);
        FillDataProviders.fillWebServer2(webServerInheritor, 1000);

        FillCaches.fillCacheDBTable(databaseTable,5);
        FillCaches.fillCacheWS1(webServer,5);
        FillCaches.fillCacheWS2(webServerInheritor,5);

        Injector.injectCache(databaseTable);
        databaseTable.printCache();

        System.out.println();
        Injector.injectCache(webServer);
        webServer.printCache();

        System.out.println();
        Injector.injectCache(webServerInheritor);
        webServerInheritor.printCache();

        System.out.println();
        TestClass4 testClass4 = new TestClass4();
        Injector.injectCache(testClass4);
        testClass4.printCache();

    }
}
