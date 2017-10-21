package com.epam.tasks.task04.ex1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komarov Vasiliy on 21.10.2017.
 */
public class ClassFinder {
    private static final char PACKAGE_SEPARATOR = '.';
    private static final char PATH_SEPARATOR = '/';
    private static final String CLASS_FILE_EXTENSION = ".class";

    public static List<Class<?>> getClassesFromPackage(String pack){
        String path = pack.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
        URL resources = ClassLoader.getSystemClassLoader().getResource(path);
        if (resources == null) {
            throw new IllegalArgumentException("Can't find resource for " + path);
        }
        return findClasses(new File(resources.getFile()), pack);
    }

    private static List<Class<?>> findClasses(File directory, String pack){
        List<Class<?>> classes = new ArrayList<>();

        if (directory == null) return classes;

        File[] files = directory.listFiles();
        if (files == null) return classes;

        for (File file : files){
            if(file.isDirectory()){
                classes.addAll(findClasses(file, pack + PACKAGE_SEPARATOR + file.getName()));
            }
            else if(file.getName().endsWith(CLASS_FILE_EXTENSION)){
                String fileName = file.getName();
                String className = fileName.substring(0, fileName.length() - CLASS_FILE_EXTENSION.length());
                try {
                    classes.add(Class.forName(pack + PACKAGE_SEPARATOR + className));
                }
                catch (ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        return classes;
    }
}
