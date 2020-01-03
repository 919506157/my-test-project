package com.zhang.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Student zhangsan = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, stuHandler);
        stuProxy.giveMoney();
        stuProxy.takeMoney();
    }

    public static void main2(String[] args) {
        try {
            Student zhangsan = new Student("张三");
            InvocationHandler sthHandler = new StuInvocationHandler<Person>(zhangsan);
            Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class[]{Person.class});
            Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
            Person person = (Person) constructor.newInstance(sthHandler);
            person.giveMoney();
            person.takeMoney();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
