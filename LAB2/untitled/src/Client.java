import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Client {
    private ClientType type;
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    /**
     * preven duplicatele verificand daca clientul adaugat deja exista in lista utilizand metoda contains() a clasei ArrayList
     */
    public static ArrayList<String> clientNames = new ArrayList<>();


    //Constructors
    public Client() { }
    public Client(String name) {
        this(name, null, null);
    }
    public Client(String name, LocalTime noon, LocalTime midnight) {
        if (!clientNames.contains(name)) {
            this.name = name;
            clientNames.add(name);
        } else {
            System.out.println("Client with name " + name + " already exists.");
        }

    }
    public Client(String name, ClientType type) {
        if (!clientNames.contains(name)) {
            this.name = name;
            clientNames.add(name);
        } else {
            System.out.println("Client with name " + name + " already exists.");
        }
        this.type = type;
    }

    // getters and setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }
    public String getName() {
        return name;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    //to string
    public String toString() {
        return name;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return type == client.type && Objects.equals(name, client.name) && Objects.equals(minTime, client.minTime) && Objects.equals(maxTime, client.maxTime);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(type, name, minTime, maxTime);
//    }
}