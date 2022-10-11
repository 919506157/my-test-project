package com.zhang.thread;

public class SynchronizedObject {


    public synchronized void method1() {

    }

    public static synchronized void method3() {

    }

    public void method2() throws InterruptedException {
        synchronized (this){
            this.wait();
        }

        synchronized (SynchronizedObject.class){

        }
    }


}
