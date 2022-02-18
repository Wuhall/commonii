package com.springboot.designpattern.prototypepattern;

/**
 * @author Wuhall
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("inside rectangle::draw() method.");
    }
}
