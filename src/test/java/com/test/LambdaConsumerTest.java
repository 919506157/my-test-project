package com.test;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda消费者函数接口
 */
public class LambdaConsumerTest {
    @Test
    public void consumerTest1() {
        //1.古董写法*****************************************
        Consumer<People> consumer1 = new Consumer<People>() {
            @Override
            public void accept(People people) {
                people.com(new User("e1", "1"));
                people.com(new User("e2", "2"));
            }
        };
        consumer1.accept(new People() {
            @Override
            public void com(User user) {
                System.out.println(user.toString());
            }
        });
    }

    @Test
    public void consumerTest1to2() {
        //1.古董写法*****************************************
        //2.写法进化*****************************************
        Consumer<User> consumer1 = user -> {
            System.out.println(user);
        };
        consumer1.accept(new User("e1", "1"));

        Consumer<User> consumer2 = this::objectPrint;
        Consumer<User> consumer3 = this::print;
        Consumer<User> consumer4 = System.out::println;
        consumer2.accept(new User("e2", "2"));
    }

    @Test
    public void consumerTest2() {
        //2.写法进化*****************************************
        Consumer<People> consumer1 = people -> {
            people.com(new User("e1", "1"));
            people.com(new User("e2", "2"));
        };
        consumer1.accept(new People() {
            @Override
            public void com(User user) {
                System.out.println(user.toString());
            }
        });
    }

    @Test
    public void consumerTest3() {
        //3.写法进化*****************************************
        Consumer<People> consumer1 = people -> {
            people.com(new User("e1", "1"));
            people.com(new User("e2", "2"));
        };
        consumer1.accept(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void consumerTest4() {
        //4.写法进化*****************************************
        Consumer<People> consumer1 = people -> {
            people.com(new User("e1", "1"));
            people.com(new User("e2", "2"));
        };
        consumer1.accept(new LambdaConsumerTest()::print);
        consumer1.accept(this::print);
        consumer1.accept(LambdaConsumerTest::staticPrint);
        consumer1.accept(System.out::println);
        consumer1.accept(this::objectPrint);
    }


    /**
     * 打印方法
     *
     * @param user
     */
    public void print(User user) {
        System.out.println(user.toString());
    }

    /**
     * 静态打印方法
     *
     * @param user
     */
    public static void staticPrint(User user) {
        System.out.println(user.toString());
    }

    public void objectPrint(Object object) {
        System.out.println(object.toString());
    }
}
