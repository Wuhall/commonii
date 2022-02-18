package com.springboot.designpattern.decoratorpattern;

/**
 * @author Wuhall
 */
public class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
