import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
import java.util.List;

//Implement the method getVehicles in the Problem class, returning an array of all the vehicles, form all depots
public class Problem {
    private Depot[] depots;
    private Client[] clients;
    ArrayList<Vehicle> vehiclesArray;

    //constructor
    public Problem(Depot[] depots) {
        this.depots = depots;
        this.vehiclesArray = new ArrayList<>();
    }
    // getters and setters
    public Depot[] getDepots() {
        return depots;
    }

    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }

    /**
     *metoda getVehicles parcurge fiecare depou si adauga vehiculele din fiecare depou in lista vehiclesArray
     */
    public ArrayList<Vehicle> getVehicles(){
        for (Depot d : depots){
            if(d.getVehicles() != null){
                this.vehiclesArray.addAll(d.getVehicles());
            }

        }
        return this.vehiclesArray;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
