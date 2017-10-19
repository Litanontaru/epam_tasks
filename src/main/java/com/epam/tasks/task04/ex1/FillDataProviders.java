package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer;
import com.epam.tasks.task04.ex1.cacheusers.WebServerInheritor;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillDataProviders {
    public static void fillDatabaseTable(DatabaseTable databaseTable, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            databaseTable.put(i, "DBT_value_" + (i+1));
        }
    }

    public static void fillWebServer1(WebServer webServer, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            webServer.put(i, "WS1_value_" + (i+1));
        }
    }

    public static void fillWebServer2(WebServerInheritor webServerInheritor, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            webServerInheritor.put(i, "WS2_value_" + (i+1));
        }
    }

}
