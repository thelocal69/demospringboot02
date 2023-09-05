package com.fourhorsemen.demospringboot02.entity;

public class StudentEntity {

    private String name;
    private int age;

    public StudentEntity() {
    }

    public StudentEntity(String name, int age) {
        this.name = name;
        this.age = age;
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
}
