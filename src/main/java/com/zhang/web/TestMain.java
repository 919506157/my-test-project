package com.zhang.web;


import com.batch.channel.service.DubboHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {

    public static final String certType = "X.509";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DubboHelloService dubboServerService = (DubboHelloService) applicationContext.getBean("demoService");
        System.out.println("***************" + dubboServerService.sayHello());
        String a = "abc";
        String b =  new String("abc");
        boolean equals = a.equals(b);
    }
}
