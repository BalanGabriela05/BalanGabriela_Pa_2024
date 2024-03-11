import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Assume that the times required to travel between the locations (depot-to-client or client-to-client)
//are known (You may generate them randomly). Implement a simple greedy algorithm for allocating clients to vehicles.
public class Tour {
    private Vehicle vehicle;
    private Client[] clients;
    ArrayList<Client> clientsArray;

    //constructor
    public Tour(Client[] clients, Vehicle vehicle){
        this.clients=clients;
        this.vehicle=vehicle;
        this.clientsArray = new ArrayList<>();

    }
    // getters and setters
    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }


    /**
     * metoda travel implementeaza logica pentru a planifica turul
     * clientii sunt sortați in functie de ora minima de sosire
     * se parcurge fiecare client si, daca timpul minim de sosire este dupa ora curenta, clientul este adaugat la lista clientsArray
     * ora curenta este actualizata cu timpul maxim de sosire al clientului
     */

    public String travel() {
        Arrays.sort(clients, Comparator.comparing(Client::getMinTime));
        LocalTime current = LocalTime.MIN;
        StringBuilder tourDetails = new StringBuilder();
        tourDetails.append("Vehicle chosen: ").append(vehicle.getName()).append("\n");
        if (clients != null) {
            for (Client c : clients) {
                if (c.getMinTime() != null && c.getMaxTime() != null) {
                    if (c.getMinTime().isAfter(current)) {
                        clientsArray.add(c);
                        current = c.getMaxTime();
                    }
                }
            }
        }
        tourDetails.append("Clients in order of visit:\n");
        for (Client client : clientsArray) {
            tourDetails.append(client.getName()).append("\n");
        }
        return tourDetails.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
