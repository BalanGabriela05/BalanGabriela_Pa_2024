public class Vehicle {
    private String name;
    private Depot depot;

    public Vehicle(String name) {
        this.name = name;
    }

    // … getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }

    public String getName() {
        return name;
    }

    // … toString
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }

}