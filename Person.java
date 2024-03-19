package org.example;

public class Person {
    String name;
    int age;
    String destination;
    boolean isDriver;

    public Person(String name, int age, String destination, boolean isDriver) {
        this.name = name;
        this.age = age;
        this.destination = destination;
        this.isDriver = isDriver;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
