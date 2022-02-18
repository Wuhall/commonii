package com.springboot.designpattern.prototypepattern;

/**
 * @author Wuhall
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("inside circle :: draw() method.");
    }
}
