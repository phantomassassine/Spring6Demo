package org.example.pojo;

/**
 * @Date: 2026/3/11 16:08
 * @Description:
 */

public class Person {
    private int age;
    private String name;
    private double height;

    public Person() {
        System.out.println("no-arg constructor");
    }
    // Alt + Insert 快捷键调出 Generator
    public Person(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
