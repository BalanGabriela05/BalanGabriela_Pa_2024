import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable{

    private String name;
    private  String location;
    private Map<DayOfWeek, TimeInterval> timetable;
    private double ticketPrice;

    public Concert(String name, String location, double ticketPrice) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
        this.timetable = new HashMap<>();
        super.setName(name);
        super.setCity(location);
    }
    /**
     *  metodă care adaugă un interval de timp la orarul unui concert pentru anumite zile
     */
    public void addTimeInterval(TimeInterval interval, String... days) {
        for (String day : days) {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            this.timetable.put(dayOfWeek, interval);
        }
    }

    @Override
    public String getCity() {
        return super.getCity();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return this.timetable;
    }

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    @Override
    public boolean isPayable() {
        return true;
    }
}
