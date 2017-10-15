package com.epam.tasks.task04.ex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komarov Vasiliy on 11.10.2017.
 */
public class Injector {
    private static final String CACHE_PACKAGE = "com.epam.tasks.task04.ex1.caches.";
    private static final String GET_INSTANCE = "getInstance";
    private static final String CACHE_DATA_FIELD = "cache";

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
                    String cacheName = getNameFromAnnotation(annotation);
                    try {
                        Class<?> cacheClass = Class.forName(CACHE_PACKAGE + cacheName);
                        Method cacheMethod = cacheClass.getMethod(GET_INSTANCE);
                        Object obj = cacheMethod.invoke(null);
                        if (Modifier.isPrivate(fields[i].getModifiers())){
                            fields[i].setAccessible(true);
                        }
                        fields[i].set(target, cacheClass.getField(CACHE_DATA_FIELD).get(obj));
                        injected = true;
                    }
                    catch (ClassNotFoundException e){
                        e.printStackTrace();
                        System.err.println("Class: " + CACHE_PACKAGE + cacheName);
                    }
                    catch (NoSuchMethodException e){
                        e.printStackTrace();
                        System.err.println("Method: \"" + GET_INSTANCE + "\"");
                    }
                    catch (IllegalAccessException | InvocationTargetException e){
                        e.printStackTrace();
                        System.err.println("Method: \"" + GET_INSTANCE + "\"");
                        System.err.println("Argument: null");
                    }
                    catch (NoSuchFieldException e){
                        e.printStackTrace();
                        System.err.println("Field: \"" + CACHE_DATA_FIELD + "\"");
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

    public static void getParentClasses(Class<?> c, List<Class> targetList){
        Class parent = c.getSuperclass();
        if (parent != null){
            targetList.add(parent);
            getParentClasses(parent, targetList);
        }
    }

    public static String getNameFromAnnotation(Annotation annotation){
        Class<?> annClass =  annotation.annotationType();
        String name = null;
        Method method = null;
        try{
            method = annClass.getMethod("name");
            name = (String) method.invoke(annotation);
        }
        catch (NoSuchMethodException e){
            e.printStackTrace();
            System.err.println("Method: \"name\"");
            System.err.println("Class: " + annClass);
        }
        catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
            System.err.println("Method: " + method);
            System.err.println("Argument: " + annotation);
        }
        return name;
    }
}