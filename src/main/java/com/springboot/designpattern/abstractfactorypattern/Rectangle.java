package com.springboot.designpattern.abstractfactorypattern;

/**
 * @author Wuhall
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
