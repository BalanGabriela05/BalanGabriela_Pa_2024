import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String args[]) {
        /**
         * COMPULSORY
         */
        Client c1 = new Client();
        c1.setName("Client 1");
        c1.setMinTime(LocalTime.of(8, 0));
        c1.setMaxTime(LocalTime.of(12, 30));
        System.out.println(c1.getName());
        Client c2 = new Client("Client 2");
        System.out.println(c2); //toString is invoked
        Client c3 = new Client("Client 3",
                LocalTime.NOON, LocalTime.MIDNIGHT);

        Client c4 = new Client("Client 4", ClientType.PREMIUM);

//        Vehicle v1 = new Vehicle("Vehicle 1");
//        Vehicle v2 = new Vehicle("Vehicle 2");
//        Vehicle v3 = new Vehicle("Vehicle 3");
//        Depot d1 = new Depot("Depot 1");
//        d1.setVehicles(v1, v2);
//        Depot d2 = new Depot("Depot 2");
//        d2.setVehicles(v3);


        /**
         * HOMEWORK
         * initial m-am gandit sa folosesc HashSet
         * acesta adauga doar dacă nu exista deja un obiect echivalent in set
         */


        //not allow adding the same depot, vehicle or client twice
//        Set<Client> clients = new HashSet<>();
//        clients.add(new Client("Alice"));
//        clients.add(new Client("Bob"));
//        clients.add(new Client("Alice"));
//
//        // Afisam lista
//        System.out.println("Lista de clienti:");
//        for (Client client : clients) {
//            System.out.println(client);
//        }
//...



        Depot d = new Depot("Depot");
        Truck truck = new Truck("Truck", 5000);
        Drone drone = new Drone("Drone", 30);
        d.setVehicles(truck,drone);
        System.out.println(truck);
        System.out.println(drone);

        System.out.println("-----------Problem Exercise");
        Vehicle v1 = new Drone("D1", 450);
        ArrayList<Vehicle> vehicles1 = new ArrayList<>();
        vehicles1.add(v1);

        Depot dep1 = new Depot("Dep1", vehicles1);
        System.out.println(dep1);

        Vehicle v2 = new Truck("T2", 3200);
        ArrayList<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(v2);

        Depot dep2 = new Depot("Dep2", vehicles2);
        System.out.println(dep2);

        //verific daca adauga dublicat
        Vehicle v3 = new Truck("T2", 3200);
        vehicles2.add(v3);

        System.out.println("Array vehicle:");
        //creeaza o instanța a clasei Problem
        Problem pb2 = new Problem(new Depot[]{dep1, dep2});

        // afișeaza toate vehiculele
       ArrayList<Vehicle> vehiclesArray = pb2.getVehicles();
        for (Vehicle vehicle : vehiclesArray) {
            System.out.println(vehicle);
       }

        System.out.println("-----------Tour Exercise");
        ArrayList<Client> clientarray = new ArrayList<>();
        Client client1 = new Client("Cl1");
        clientarray.add(client1);
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));
        Client client2 = new Client("Cl2");
        clientarray.add(client2);
        client2.setMinTime(LocalTime.of(4, 0));
        client2.setMaxTime(LocalTime.of(6, 30));
        Client client3 = new Client("Cl3");
        clientarray.add(client3);
        client3.setMinTime(LocalTime.of(7, 0));
        client3.setMaxTime(LocalTime.of(8, 0));

        Tour tr=new Tour(new Client[]{client1,client2,client3},v2);
        System.out.println("Tour details:\n" + tr.travel());
    }
}