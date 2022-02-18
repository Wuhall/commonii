package com.springboot.designpattern.abstractfactorypattern;

/**
 * @author Wuhall
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("inside blue::fill() method.");
    }
}
