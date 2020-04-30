package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 工厂也是一个函数式接口
 */
public interface CTS2 {
    static CTS2 getInstance(Consumer<People2> consumer) {
        Map<String, Supplier<User2>> map = new HashMap<>();
        consumer.accept(map::put);
        return id -> map.get(id).get();
    }

    /**
     * 只有一个抽象方法
     *
     * @param id
     * @return
     */
    User2 getUser2(String id);
}

/**
 * 测试方法
 */
class TestCTS2 {
    public static void main(String[] args) {
        CTS2 instance = CTS2.getInstance(people2 -> {
            people2.com("1", () -> new User2("用户1"));
            people2.com("2", () -> new User2("用户2"));
            people2.com("3", () -> new User2("用户3"));
        });
        User2 user2 = instance.getUser2("1");
        System.out.println(user2);
    }
}

interface People2 {
    void com(String id, Supplier<User2> supplier);
}

/**
 * 实体
 */
class User2 {
    private String name;

    public User2() {
    }

    public User2(String name) {
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
        return "User2{" +
                "name='" + name + '\'' +
                '}';
    }
}
