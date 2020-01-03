package com.zhang.proxy;

/**
 * 计时工具类
 */
public class MonitorUtil {
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start() {
        t1.set(System.currentTimeMillis());
    }

    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (System.currentTimeMillis() - t1.get()));
    }
}
