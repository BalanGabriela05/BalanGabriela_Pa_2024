import java.time.LocalTime;

public class Main {
    public static void main(String args[]) {
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

        Vehicle v1 = new Vehicle("Vehicle 1");
        Vehicle v2 = new Vehicle("Vehicle 2");
        Vehicle v3 = new Vehicle("Vehicle 3");
        Depot d1 = new Depot("Depot 1");
        d1.setVehicles(v1, v2);
        Depot d2 = new Depot("Depot 2");
        d2.setVehicles(v3);

        // Crearea unui obiect de tip Depot
        Depot depot = new Depot("Depozit 1");
        // Crearea unui obiect de tip Vehicle
        Vehicle vehicle = new Vehicle("Vehicul 1");
        // Crearea unui obiect de tip Client
        Client client = new Client("Client 1", ClientType.REGULAR);
        // Afișarea obiectului de tip Depot
        System.out.println("Depozit: " + depot);
        // Afișarea obiectului de tip Vehicle
        System.out.println("Vehicul: " + vehicle);
        // Afișarea obiectului de tip Client
        System.out.println("Client: " + client);
    }
}