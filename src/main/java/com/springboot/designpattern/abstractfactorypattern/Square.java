package com.springboot.designpattern.abstractfactorypattern;

/**
 * @author Wuhall
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("inside square :: draw() method.");
    }
}
