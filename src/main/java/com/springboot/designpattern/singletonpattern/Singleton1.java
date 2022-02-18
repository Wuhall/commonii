package com.springboot.designpattern.singletonpattern;

/**
 * @author Wuhall
 * 懒汉 实现延迟初始化
 */
public class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {}

    //此方式线程不安全
    public static Singleton1 getSingleton1() {
        if (singleton1 == null) {
            return new Singleton1();
        }
        return singleton1;
    }

    //线程安全的方式 ，synchronized 影响性能
    public static synchronized Singleton1 getSingleton2() {
        if (singleton1 == null) {
            return new Singleton1();
        }
        return singleton1;
    }

    // 双重校验锁
    public static Singleton1 getSingleton3() {
        // 判空第一层，在多线程的场景下可能会有多个线程进入第一层的if
        if (singleton1 == null) {
            // 判空第二层
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }

    /**
     * 静态内部类的方式实现
     */
    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static final Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
