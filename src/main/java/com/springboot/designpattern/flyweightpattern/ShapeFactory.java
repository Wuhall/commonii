package com.springboot.designpattern.flyweightpattern;

import java.util.HashMap;

/**
 * @author Wuhall
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("creating circle of color:" + color);
        }
        return circle;
    }
}
