package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.data.DatabaseTable;
import com.epam.tasks.task04.ex1.data.WebServer1;
import com.epam.tasks.task04.ex1.data.WebServer2;

/**
 * Created by Komarov Vasiliy on 12.10.2017.
 */
public class FillDataProviders {
    public static void fillDatabaseTable(int elementsCount){
        DatabaseTable databaseTable = DatabaseTable.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            databaseTable.put(i, "DBT_value_" + (i+1));
        }
    }

    public static void fillWebServer1(int elementsCount){
        WebServer1 webServer1 = WebServer1.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            webServer1.put(i, "WS1_value_" + (i+1));
        }
    }

    public static void fillWebServer2(int elementsCount){
        WebServer2 webServer2 = WebServer2.getInstance();
        for (int i = 0; i < elementsCount; i++) {
            webServer2.put(i, "WS2_value_" + (i+1));
        }
    }

}
