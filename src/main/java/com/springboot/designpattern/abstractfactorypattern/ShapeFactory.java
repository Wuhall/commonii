package com.springboot.designpattern.abstractfactorypattern;

import org.junit.Test;

/**
 * @author Wuhall
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        if (shape.equalsIgnoreCase("square")) {
            return new Square();
        }
        return null;
    }

    @Test
    public void test1() {
        ShapeFactory shapeFactory = new ShapeFactory();
        // 获取具体对象
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();
    }
}
