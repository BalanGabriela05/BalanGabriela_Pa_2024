//In Visitable.java
import java.time.LocalDate;
import java.util.Map;
public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();

    default int getOpeningHour(LocalDate date) {
        TimeInterval timeInterval = getTimetable().get(date);
        if (timeInterval != null) {
            return timeInterval.getOpeningHour().getHour();

        }
        return 0;
    }
}