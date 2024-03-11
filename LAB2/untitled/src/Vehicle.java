import java.util.ArrayList;
import java.util.Objects;

//Vehicles may be of different types. Create dedicated classes for trucks and drones.
// Trucks have a capacity property, while drones have a maximum flight duration (these properties will not be used by the algorithms).
// The Vehicle class will become abstract.
abstract class Vehicle {
    protected String name;
    private Depot depot;
    public Vehicle(){};
    /**
     * preven duplicatele verificand daca vehiculul adaugat deja exista in lista utilizand metoda contains() a clasei ArrayList
     */
    public static ArrayList<String> vehicleNames = new ArrayList<>();

    public Vehicle(String name) {
        if (!vehicleNames.contains(name) ) {
            this.name = name;
            vehicleNames.add(name);
        } else {
            System.out.println("Vehicle with name " + name + " already exists.");
        }
    }

    // getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '}';
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, depot);
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }

}
    // Truck class
    class Truck extends Vehicle {
        private int capacity;

        public Truck(String name, int capacity) {
            super(name);
            this.capacity = capacity;

        }
        public Truck(){};

        public int getCapacity() {
            return capacity;
        }
}

    // Drone class
    class Drone extends Vehicle {
        private int maxFlightDuration;

        public Drone(String name, int maxFlightDuration ) {
            super(name);
            this.maxFlightDuration = maxFlightDuration;

        }
        public Drone(){};

        public int getMaxFlightDuration() {
            return maxFlightDuration;
        }

    }
