package com.springboot.designpattern.abstractfactorypattern;

/**
 * @author Wuhall
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("inside green::fill() method.");
    }
}
