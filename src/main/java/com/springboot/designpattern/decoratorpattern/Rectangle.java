package com.springboot.designpattern.decoratorpattern;

/**
 * @author Wuhall
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}
