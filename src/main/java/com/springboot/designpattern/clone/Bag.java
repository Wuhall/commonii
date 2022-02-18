package com.springboot.designpattern.clone;

import java.io.Serializable;

/**
 * @author Wuhall
 */
public class Bag implements Serializable {
    private int size;

    public Bag(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
