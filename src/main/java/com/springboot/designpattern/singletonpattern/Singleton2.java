package com.springboot.designpattern.singletonpattern;

/**
 * @author Wuhall
 * 饿汉 没有实现延迟初始化
 */
public class Singleton2 {
    private static Singleton2 singleton1 = new Singleton2();

    private Singleton2() {}

    // 线程安全，但在类加载时就初始化对象，浪费内存
    public static Singleton2 getSingleton() {
        return singleton1;
    }
}
