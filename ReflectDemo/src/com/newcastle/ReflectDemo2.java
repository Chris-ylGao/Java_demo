package com.newcastle;

import java.io.InputStream;
import java.util.Properties;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        ClassLoader classLoader = ReflectDemo2.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("pro.properties");
        properties.load(in);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);

        Object obj = cls.getDeclaredConstructor(String.class,int.class).newInstance("Mile",20);
        //cls.getDeclaredMethod(methodName).invoke("Dan");
        System.out.println(obj);


    }
}
