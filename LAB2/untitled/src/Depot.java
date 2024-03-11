import java.util.ArrayList;
import java.util.Objects;

public class Depot {
    private String name;
    private ArrayList<Vehicle> vehicles;
    /**
     * preven duplicatele verificand daca depoul adaugat deja exista in lista utilizand metoda contains() a clasei ArrayList
     */
    public static ArrayList<String> depotNames = new ArrayList<>();


    // constructor(s)
    public Depot(String name) {
        if (!depotNames.contains(name)) {
            this.name = name;
            depotNames.add(name);
        } else {
            System.out.println("Depot with name " + name + " already exists.");
        }
        this.vehicles = new ArrayList<>();
    }

    public Depot(String name, ArrayList<Vehicle> vehicles){
        if (!depotNames.contains(name)) {
            this.name = name;
            depotNames.add(name);
        } else {
            System.out.println("Depot with name " + name + " already exists.");
        }
        this.vehicles = new ArrayList<>();
        this.vehicles.addAll(vehicles);
    }


    // getter and setter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /**
     * metoda setVehicles primește un numar variabil de vehicule si le adauga la lista de vehicule a depoului
     * seteaza depoul curent ca fiind depoul asociat fiecarui vehicul.
     * @param vehicles
     */
    public void setVehicles(Vehicle ... vehicles) {

        for(Vehicle v : vehicles) {
            v.setDepot(this);
            this.vehicles.add(v);
        }
    }

    //getVehicles
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    //to string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Depot: ").append(name).append("\n");
        sb.append("Vehicles:\n");
        for (Vehicle v : vehicles) {
            sb.append("- ").append(v).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name) && Objects.equals(vehicles, depot.vehicles);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, vehicles);
//    }

}
