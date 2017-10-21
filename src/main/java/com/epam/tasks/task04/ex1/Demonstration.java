package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.ExternalHD;
import com.epam.tasks.task04.ex1.cacheusers.WebServer;
import com.epam.tasks.task04.ex1.cacheusers.WebServerInheritor;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class Demonstration {
    public static void start(){
        DatabaseTable databaseTable = new DatabaseTable();
        ExternalHD externalHD = new ExternalHD();
        WebServer webServer = new WebServer();
        WebServerInheritor webServerInheritor = new WebServerInheritor();

        CacheInstances.initialize();
        CacheInstances.getCaches()
                .forEach((cache) -> FillCaches.fillCache(cache, 5));

        Injector.injectCache(databaseTable);
        databaseTable.printCache();

        System.out.println();
        Injector.injectCache(externalHD);
        webServer.printCache();

        System.out.println();
        Injector.injectCache(webServer);
        webServer.printCache();

        System.out.println();
        Injector.injectCache(webServerInheritor);
        webServerInheritor.printCache();

        System.out.println();
        try{
            Injector.injectCache(new Object());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
