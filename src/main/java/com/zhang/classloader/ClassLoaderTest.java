package com.zhang.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> loadClass = classLoader.loadClass("com.zhang.bean.User");
        System.out.println(loadClass.getClassLoader());

//        new app

        StringBuilder stringBuilder = new StringBuilder("123");
        stringBuilder.append("123");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
    }
}
