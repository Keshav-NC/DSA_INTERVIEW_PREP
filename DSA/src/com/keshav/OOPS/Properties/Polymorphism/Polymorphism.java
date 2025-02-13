package com.keshav.OOPS.Properties.Polymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        Person person = new Person();
        Father father = new Father();
        Husband husband = new Husband();
        Person employee = new Employee();

//        person.role();
//        father.role();
//        husband.role();
        employee.role();

    }
}
