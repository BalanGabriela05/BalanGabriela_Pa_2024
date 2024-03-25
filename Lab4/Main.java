package org.example;
import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Maria", 30, "Suceava", true);
        Person person2 = new Person("Ioana", 20, "Suceava", false);
        Person person3 = new Person("Ana", 18, "Suceava", false);
        Person person4 = new Person("Andrei", 38, "Iasi", true);
        Person person5 = new Person("Florin", 30, "Iasi", false);
        Person person6 = new Person("Robert", 25, "Iasi", true);
        Person person7 = new Person("Ionut", 22, "Bucuresti", true);
        Person person8 = new Person("Gabriela", 21, "Brasov", false);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);

        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println();

        System.out.println("-----Compulsory-----");
        // Filtrarea șoferilor și pasagerilor
        List<Person> drivers = persons.stream()
                .filter(Person::isDriver)
                .collect(Collectors.toList());

        List<Person> passengers = persons.stream()
                .filter(p -> !p.isDriver())
                .collect(Collectors.toList());

        // Punerea tuturor șoferilor într-o LinkedList și imprimarea lor sortată după vârstă
        LinkedList<Person> driversSortedByAge = drivers.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Drivers sorted by age:");
        driversSortedByAge.forEach(d -> System.out.println(d.getName() + " (" + d.getAge() + ")"));

        // Punerea tuturor pasagerilor într-un TreeSet și imprimarea lor sortată după nume
        TreeSet<Person> passengersSortedByName = new TreeSet<>(Comparator.comparing(Person::getName));
        passengersSortedByName.addAll(passengers);

        System.out.println("Passengers sorted by name:");
        passengersSortedByName.forEach(p -> System.out.println(p.getName()));

        System.out.println("-----Homework-----");
        // Lista cu toate locațiile
        /**
         * Set-> nu permite dublicate
         * map-> transforma fluxul de persoane într-un flux de destinații
         */
        Set<String> allDestinations = persons.stream()
                .map(Person::getDestination)
                .collect(Collectors.toSet());

        System.out.println("All the destinations that the drivers pass through:");
        allDestinations.forEach(System.out::println);

        //Lista cu locații și persoanele care doresc să meargă în locația respectiva
        /**
         * groupingBy-> grupez persoanele în funcție de destinația lor
         * Map-> interfață care stochează perechi cheie (destinatie) - valoare (lista persoane)
         * joining-> unește elementele unui stream într-un String, folosind un delimitator
         */
        Map<String, List<Person>> destinationMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getDestination));

        System.out.println("All the destinations and people who want to go there:");
        destinationMap.forEach((destination, people) -> {
            String peopleNames = people.stream()
                    .map(Person::getName)
                    .collect(Collectors.joining(", "));
            System.out.println(destination + ": [ " + peopleNames + " ]");
        });

        System.out.println();
        //random fake names for persons and destinations
        Faker faker = new Faker();

        for (int i = 0; i < 6; i++) {
            String name = faker.name().firstName();
            String city = faker.address().city();

            System.out.print("Nume: " + name + ", ");
            System.out.println("Oraș: " + city);
        }

        System.out.println();
        System.out.println("greedy algorithm :");
        //Create a greedy algorithm in order to solve the problem.
        Map<Person, Person> potriviri = new HashMap<>();

        for(Person sofer : drivers) {
            List<Person> pasageriPotriviti = new ArrayList<>();
            if (destinationMap.containsKey(sofer.getDestination())) {
                for (Person persoana : passengers) {
                    if (sofer.getDestination().equals(persoana.getDestination())) {
                        pasageriPotriviti.add(persoana);
                    }
                }
            }
            if (!pasageriPotriviti.isEmpty()) {
                Person pasager = pasageriPotriviti.get(0);
                potriviri.put(sofer, pasager);
                pasageriPotriviti.remove(pasager);
            }
            if (pasageriPotriviti.isEmpty()) {
                destinationMap.remove(sofer.getDestination());
            }
        }

        // Parcurge șoferii și pasagerii rămași
        for (Person sofer : drivers) {
            for (Person pasager : passengers) {
                if (!potriviri.containsKey(sofer) && !potriviri.containsValue(pasager)) {
                    potriviri.put(sofer, pasager);
                    break;
                }
            }
        }


        for (Map.Entry<Person, Person> potrivire : potriviri.entrySet()) {
            String destinatieSofer = potrivire.getKey().getDestination();
            String destinatiePasager = potrivire.getValue().getDestination();

            System.out.print("Șofer: " + potrivire.getKey().getName());
            System.out.print(", Pasager: " + potrivire.getValue().getName());

            if (!destinatieSofer.equals(destinatiePasager)) {
                System.out.println(", Trece prin: " + destinatiePasager + ", Destinația finală: " + destinatieSofer);
            } else {
                System.out.println(", Destinația: " + destinatieSofer);
            }
        }


    }

}