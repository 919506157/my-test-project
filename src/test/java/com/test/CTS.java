package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Consumer To Supplier 工厂普通写法，用于理解
 */
public interface CTS {

    static CTS getCts(Consumer<People1> consumer) {
        //1.lambda写法
        /*Map<String, Supplier<User1>> map = new HashMap<>();
        consumer.accept(map::put);
        return consumer1 -> map.get(consumer1).get();*/
        //2.普通写法
        Map<String, Supplier<User1>> map = new HashMap<>();
        consumer.accept(new People1() {
            @Override
            public void come(String name, Supplier<User1> user1Supplier) {
                map.put(name, user1Supplier);
            }
        });
        return new CTS() {
            @Override
            public User1 getUser1(String name) {
                Supplier<User1> user1Supplier = map.get(name);
                return user1Supplier.get();
            }
        };

    }

    User1 getUser1(String name);
}


class TTT {
    public static void main(String[] args) {
        /*CTS cts = CTS.getCts(perple -> {
            perple.come("1", () -> new User1("用户1"));
            perple.come("2", () -> new User1("用户2"));
            perple.come("3", () -> new User1("用户3"));
        });
        User1 user1 = cts.getUser1("2");
        System.out.println(user1.toString());*/
        //普通写法
        CTS cts = CTS.getCts(new Consumer<People1>() {
            @Override
            public void accept(People1 people1) {
                people1.come("1", new Supplier<User1>() {
                    @Override
                    public User1 get() {
                        return new User1("用户1");
                    }
                });
                people1.come("2", new Supplier<User1>() {
                    @Override
                    public User1 get() {
                        return new User1("用户2");
                    }
                });
                people1.come("3", new Supplier<User1>() {
                    @Override
                    public User1 get() {
                        return new User1("用户3");
                    }
                });
            }
        });
        User1 user1 = cts.getUser1("2");
        System.out.println(user1);
    }
}


/**
 * 接口
 */
interface People1 {
    void come(String name, Supplier<User1> user1Supplier);
}


/**
 * 实体类
 */
class User1 {
    private String name;

    public User1() {
    }

    public User1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                '}';
    }
}
