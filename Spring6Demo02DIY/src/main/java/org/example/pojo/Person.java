package org.example.pojo;

/**
 * @Date: 2026/3/11 17:01
 * @Description:
 */

public class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("Person空构造器");
    }

    public Person(int age, String name) {
        System.out.println("Person有参构造器");
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("Person.eat");
    }
}
