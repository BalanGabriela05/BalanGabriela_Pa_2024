import java.time.DayOfWeek;
import java.util.Map;
import java.util.HashMap;

public class Statue extends Attraction implements Visitable {
    private String name;
    private String location;
    private Map<DayOfWeek, TimeInterval> timetable;

    public Statue(String name, String location) {
        this.name = name;
        this.location = location;
        this.timetable = new HashMap<>();
        super.setName(name);
        super.setCity(location);

    }

    /**
     *  metodă care adaugă un interval de timp la orarul unei statui pentru anumite zile
     */
    public void addTimeInterval(TimeInterval interval, String... days) {
        for (String day : days) {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            this.timetable.put(dayOfWeek, interval);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCity(String city) {
        super.setCity(city);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return this.timetable;
    }

}


