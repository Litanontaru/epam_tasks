package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.cacheusers.DatabaseTable;
import com.epam.tasks.task04.ex1.cacheusers.WebServer1;
import com.epam.tasks.task04.ex1.cacheusers.WebServer2;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillDataProviders {
    public static void fillDatabaseTable(DatabaseTable databaseTable, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            databaseTable.put(i, "DBT_value_" + (i+1));
        }
    }

    public static void fillWebServer1(WebServer1 webServer1, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            webServer1.put(i, "WS1_value_" + (i+1));
        }
    }

    public static void fillWebServer2(WebServer2 webServer2, int elementsCount){
        for (int i = 0; i < elementsCount; i++) {
            webServer2.put(i, "WS2_value_" + (i+1));
        }
    }

}
