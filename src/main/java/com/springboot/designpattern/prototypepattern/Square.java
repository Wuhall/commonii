package com.springboot.designpattern.prototypepattern;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Wuhall
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("inside square::draw() method.");
    }
}
