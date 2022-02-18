package com.springboot.designpattern.prototypepattern;

import java.io.ObjectInputStream;

/**
 * @author Wuhall
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected  String type;

    abstract void draw();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
