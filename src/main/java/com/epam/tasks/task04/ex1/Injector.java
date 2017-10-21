package com.epam.tasks.task04.ex1;

import com.epam.tasks.task04.ex1.annotations.InjectCache;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class Injector {

    public static void injectCache(Object target){
        boolean injected = false;

        Class<?> targetClass = target.getClass();

        List<Class> listClasses = new ArrayList<>();
        listClasses.add(targetClass);

        Injector.getParentClasses(targetClass, listClasses);

        for (Class<?> cls : listClasses ){
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Annotation annotation = fields[i].getAnnotation(InjectCache.class);
                if (annotation != null) {
                    InjectCache injectCacheAnn = (InjectCache) annotation;
                    String cacheName = injectCacheAnn.name();
                    if (Modifier.isPrivate(fields[i].getModifiers())){
                        fields[i].setAccessible(true);
                    }
                    try {
                        fields[i].set(target, CacheInstances.getCacheInstance(cacheName));
                        injected = true;
                    }
                    catch (IllegalAccessException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if (!injected){
            throw new IllegalArgumentException("Class "
                    + targetClass.getName()
                    + " and its parents don't have annotation 'InjectCache'");
        }
    }

    private static void getParentClasses(Class<?> c, List<Class> targetList){
        Class parent = c.getSuperclass();
        if (parent != null){
            targetList.add(parent);
            getParentClasses(parent, targetList);
        }
    }
}