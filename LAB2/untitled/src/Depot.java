import java.util.Arrays;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    // … constructor(s)
    public Depot(String name) {
        this.name = name;
    }

    public Depot(){}
    public Depot(String name, Vehicle[] vehicles){
        this.name = name;
        this.vehicles = vehicles;
    }

    // … getter and setter for name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setVehicles(Vehicle ... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    // … getVehicles
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    // … toString
    public String toString() {
        return name;
    }

    // … equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obj;
        return name.equals(other.name) && Arrays.equals(vehicles, other.vehicles);
    }
}
