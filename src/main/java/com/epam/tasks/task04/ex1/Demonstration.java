package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.tests.*;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class Demonstration {
    public static void start(){
        FillDataProviders.fillDatabaseTable(1000);
        FillDataProviders.fillWebServer1(1000);
        FillDataProviders.fillWebServer2(1000);

        FillCaches.fillCacheDBTable(5);
        FillCaches.fillCacheWS1(5);
        FillCaches.fillCacheWS2(5);

        TestClass1 testClass1 = new TestClass1();
        Injector.injectCache(testClass1);
        testClass1.printCache();

        System.out.println();
        TestClass2 testClass2 = new TestClass2();
        Injector.injectCache(testClass2);
        testClass2.printCache();

        System.out.println();
        TestClass3 testClass3 = new TestClass3();
        Injector.injectCache(testClass3);
        testClass3.printCache();

        System.out.println();
        TestClass4 testClass4 = new TestClass4();
        Injector.injectCache(testClass4);
        testClass4.printCache();

        System.out.println();
        TestClass5 testClass5 = new TestClass5();
        Injector.injectCache(testClass5);
        testClass5.printCache();
    }
}
