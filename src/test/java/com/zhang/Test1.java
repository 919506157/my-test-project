package com.zhang;


public class Test1 {
    public static void main(String[] args) {
        A a = new A();
        new Thread(a).start();
        for (int i = 0;i<10000;i++){
            new Object();
        }
        int j = a.i;
        System.out.println(j);
    }
}

class A implements Runnable {

    public volatile int i = 1;

    @Override
    public void run() {
        this.i = 10;
    }
}