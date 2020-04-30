package com.test;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Lambda提供商函数接口
 */
public class LambdaSupplierTest {

    @Test
    public void SupplierTest1() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "这是我想要的字符串";
            }
        };
        String a = supplier.get();
        System.out.println(a);
    }

    @Test
    public void SupplierTest2() {
        Supplier<User> supplier1 = () -> {
            User user = new User("邮箱1", "密码1");
            return user;
        };
        User user = supplier1.get();

        Supplier<User> supplier2 = this::getUser;
        supplier2.get();
    }

    @Test
    public void SupplierTest3() {
        Supplier<People> supplier1 = new Supplier<People>() {
            @Override
            public People get() {
                People people = new People() {
                    @Override
                    public void com(User user) {
                        System.out.println(user);
                    }
                };
                return people;
            }
        };
        People people = supplier1.get();
        people.com(new User("e1", "1"));
    }
    @Test
    public void SupplierTest4() {
        Supplier<People> supplier1 = new Supplier<People>() {
            @Override
            public People get() {
                People people = new People() {
                    @Override
                    public void com(User user) {
                        System.out.println(user);
                    }
                };
                return people;
            }
        };
        People people = supplier1.get();
        people.com(new User("e1", "1"));
    }

    @Test
    public void SupplierTest5() {
        //跟上个一堆代码等价
        Supplier<People> supplier1 = () -> System.out::println;
        People people = supplier1.get();
        people.com(new User("e1", "1"));
    }

    /**
     * 获取user
     *
     * @return
     */
    public User getUser() {
        return new User("e1", "2");
    }
}
