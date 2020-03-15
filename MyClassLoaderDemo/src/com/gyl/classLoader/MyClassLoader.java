package com.gyl.classLoader;

import java.io.*;

/**
 * MyClassLoader: write a class loader to simulate app class loader to find and load .class file.
 */
public class MyClassLoader extends ClassLoader {
    private String path; // the path of .class file
    private String classLoaderName; // name of class loader

    public MyClassLoader(String path, String classLoaderName){
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    // fine .class file
    @Override
    public  Class findClass(String name){
        byte[] bytes = loadClassData(name);
        return defineClass(name,bytes,0,bytes.length);
    }

    // load .class file
    private byte[] loadClassData(String name){
        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            in  = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i;
            while((i = in.read())!=-1){
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
