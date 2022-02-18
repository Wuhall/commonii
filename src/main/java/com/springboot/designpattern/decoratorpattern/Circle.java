package com.springboot.designpattern.decoratorpattern;

/**
 * @author Wuhall
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle");
    }
}
