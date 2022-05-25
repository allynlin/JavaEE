package com.cshbxy.pojo;

public class Dog {
    private String brand; //品种
    private int age; //年龄

    public Dog() {
    }

    public Dog(String brand, int age) {
        this.brand = brand;
        this.age = age;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "brand='" + brand + '\'' +
                ", age=" + age +
                '}';
    }
}