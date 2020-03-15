package com.gyl.classLoader;

import java.lang.reflect.InvocationTargetException;

public class UseMyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = new MyClassLoader("/Users/gyl/Desktop/","myClassLoader");

        Class test = classLoader.loadClass("Test");
        System.out.println(test.getClassLoader());
        test.getDeclaredConstructor().newInstance();
    }
}
