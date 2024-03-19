package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Maria",30,"Suceava",true);
        Person person2 = new Person("Ioana",20,"Suceava",false);
        Person person3 = new Person("Ana",18,"Suceava",false);
        Person person4 = new Person("Andrei",38,"Iasi",true);
        Person person5 = new Person("Florin",30,"Iasi",false);
        Person person6 = new Person("Robert",25,"Iasi",true);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println();

        LinkedList<Person> drivers = persons.stream()
                .filter(Person::isDriver)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));


        TreeSet<Person> passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        passengers.addAll(persons.stream().filter(p -> !p.isDriver()).collect(Collectors.toList()));


        System.out.println("Drivers sorted by age: " + drivers);
        System.out.println("Passengers sorted by name: " + passengers);

    }
}