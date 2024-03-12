import java.time.LocalDate;
import java.time.LocalTime;

public class Pair<T, U> {
    private T first;
    private U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
//getters, [setters?], toString, equals
}
//preparing for later development
class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }

    public LocalTime getOpeningHour() {
        return null;
    }
}