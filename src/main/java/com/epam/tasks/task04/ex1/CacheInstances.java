package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.annotations.CacheDeclaration;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Komarov Vasiliy on 19.10.2017.
 */
public class CacheInstances {
    private static final String CACHE_PACKAGE = "com.epam.tasks.task04.ex1.caches";
    private static Map<String, Cache> caches = new HashMap<>();

    public static void initialize(){
        List<Class<?>> classes = ClassFinder.getClassesFromPackage(CACHE_PACKAGE);
        for (Class<?> cls : classes){
            Annotation annotation = cls.getAnnotation(CacheDeclaration.class);
            if (annotation != null){
                try {
                    CacheDeclaration cacheDeclarationAnn = (CacheDeclaration) annotation;
                    caches.put(cacheDeclarationAnn.name(), (Cache)cls.newInstance());
                }
                catch (InstantiationException | IllegalAccessException e){
                    e.getMessage();
                }
            }
        }
    }

    public static Map<String, Cache> getMapCaches(){
        return caches;
    }

    public static Cache getCacheInstance(String cacheName){
        return caches.get(cacheName);
    }
}
