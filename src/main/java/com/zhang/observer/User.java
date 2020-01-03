package com.zhang.observer;


public class User implements Observer {
    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.message = msg;
        read();
    }

    public void read() {
        System.out.println(name + "收到消息" + message);
    }
}
