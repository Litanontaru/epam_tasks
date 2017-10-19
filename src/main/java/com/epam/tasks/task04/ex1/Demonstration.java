package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer1;
import com.epam.tasks.task04.ex1.cacheusers.WebServer2;
import com.epam.tasks.task04.ex1.tests.*;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class Demonstration {
    public static void start(){
        DatabaseTable databaseTable = new DatabaseTable();
        WebServer1 webServer1 = new WebServer1();
        WebServer2 webServer2 = new WebServer2();

        FillDataProviders.fillDatabaseTable(databaseTable, 1000);
        FillDataProviders.fillWebServer1(webServer1, 1000);
        FillDataProviders.fillWebServer2(webServer2, 1000);

        FillCaches.fillCacheDBTable(databaseTable,5);
        FillCaches.fillCacheWS1(webServer1,5);
        FillCaches.fillCacheWS2(webServer2,5);

        Injector.injectCache(databaseTable);
        databaseTable.printCache();

        System.out.println();
        Injector.injectCache(webServer1);
        webServer1.printCache();

        System.out.println();
        Injector.injectCache(webServer2);
        webServer2.printCache();

        System.out.println();
        TestClass4 testClass4 = new TestClass4();
        Injector.injectCache(testClass4);
        testClass4.printCache();

    }
}
