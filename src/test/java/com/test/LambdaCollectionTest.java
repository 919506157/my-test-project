package com.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * lambda集合测试
 */
public class LambdaCollectionTest {

    @Test
    public void test3() {
        List<String> list = Arrays.asList("a", "ab", "abc", "abcd");

        list.stream();
    }

    @Test
    public void test2() {
        String[] a = new String[]{"a", "ab", "abc", "abcd"};

    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("a", "ab", "abc", "abcd");
        list.forEach(System.out::println);
        list.forEach(a -> {
            //a = a + "*";
            //a = "123";
            a = new String("123");
            System.out.println(a);
        });
        list.forEach(System.out::println);


        /*List<User> list1 = Arrays.asList(new User("e1", "1"), new User("e2", "2"));
        list1.forEach(user -> {
            user = new User("e3", "3");
            System.out.println(user);
        });*/
    }
}
