import java.time.LocalTime;
public class Client {
    private ClientType type;
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;

    //Constructors
    public Client() { }
    public Client(String name) {
        this(name, null, null);
    }

    public Client(String name, LocalTime noon, LocalTime midnight) {
        this.name = name;
    }

    public Client(String name, ClientType type) {
        this.name = name;
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
    //tostring
    public String toString() {
        return name;
    }


}