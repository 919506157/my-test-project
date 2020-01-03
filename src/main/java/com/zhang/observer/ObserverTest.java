package com.zhang.observer;

/**
 * 观察者模式测试
 */
public class ObserverTest {
    public static void main(String[] args) {
        //创建一个公众号
        WechatServer wechatServer = new WechatServer();
        //创建四个模拟用户
        User user1 = new User("张三");
        User user2 = new User("李四");
        User user3 = new User("网二");
        User user4 = new User("赵五");
        //注册用户，模拟关注公众号
        wechatServer.registerObserver(user1);
        wechatServer.registerObserver(user2);
        wechatServer.registerObserver(user3);
        wechatServer.registerObserver(user4);

        System.out.println(user1);

        wechatServer.setMessage("java是世界上最好的语言");

        System.out.println(user1);
        System.out.println("------------------");

        wechatServer.removeObserver(user1);
        wechatServer.setMessage("java永远是世界上最好的语言");
        System.out.println(user1);
    }
}
