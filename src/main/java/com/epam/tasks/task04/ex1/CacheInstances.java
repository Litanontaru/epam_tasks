package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.annotations.CacheDeclaration;
import com.epam.tasks.task04.ex1.caches.CacheDBTable;
import com.epam.tasks.task04.ex1.caches.CacheExternalHD;
import com.epam.tasks.task04.ex1.caches.CacheWS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komarov Vasiliy on 19.10.2017.
 */
public class CacheInstances {
    private static final String CACHE_PACKAGE = "com.epam.tasks.task04.ex1.caches";
    private static List<Cache> caches = new ArrayList<>();

    public static void initialize(){
        //caches.add(new CacheDBTable());
        //caches.add(new CacheExternalHD());
        //caches.add(new CacheWS());
        //TODO: Add all classes of Caches from package
        List<Class<?>> classes = ClassFinder.getClassesFromPackage(CACHE_PACKAGE);
        for (Class<?> cls : classes){
            if (cls.getAnnotation(CacheDeclaration.class) != null){
                try {
                    caches.add((Cache)cls.newInstance());
                }
                catch (InstantiationException | IllegalAccessException e){
                    e.getMessage();
                }
            }
        }
    }

    public static List<Cache> getCaches(){
        return caches;
    }
}
