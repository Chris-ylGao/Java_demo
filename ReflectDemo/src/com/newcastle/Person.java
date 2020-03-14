package com.newcastle;

public class Person {
    private String name;
    private int age;
    private int idNumber;

    public int a;
    protected int b;
    int c;
    private int d;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.idNumber = name.hashCode() + age;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public int getIdNumber(){
        return name.hashCode() + age;
    }

    public void changeName(String name){
        this.name = name;
    }

    public String toString(){
        return name + ", " + age  + ", " + idNumber;
    }
}
