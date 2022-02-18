package com.springboot.designpattern.abstractfactorypattern;

/**
 * @author Wuhall
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("inside Circle :: draw() method.");
    }
}
