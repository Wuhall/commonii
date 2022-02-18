package com.springboot.designpattern.clone;

import java.io.*;

/**
 * @author Wuhall
 */
public class Student implements Cloneable,Serializable {
    private String name;
    private int age;
    private Bag bag;

    public Student(String name, int age, Bag bag) {
        this.name = name;
        this.age = age;
        this.bag = bag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bag=" + bag +
                '}';
    }



    public static void main(String[] args) {
        Bag b = new Bag(1);
        Student s1 = new Student("Ming", 1, b);
        try {
            Student s2 = s1.clone();
            // 浅克隆
            System.out.println(s1 == s2);
            System.out.println(s1.getBag() == s2.getBag());
            try {
                // 序列化实现深克隆
                // 序列化对象
                FileOutputStream fileOutputStream = new FileOutputStream("E:/test.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(s1);
                oos.close();
                fileOutputStream.close();
                // 反序列化对象
                FileInputStream fileInputStream = new FileInputStream("E:/test.txt");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                Student s3 = (Student)ois.readObject();
                System.out.println(s1 == s3);
                System.out.println(s1.getBag() == s3.getBag());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
