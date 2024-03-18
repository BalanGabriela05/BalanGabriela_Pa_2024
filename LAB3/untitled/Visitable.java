import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
public interface Visitable {
    Map<DayOfWeek, TimeInterval> getTimetable();

    default LocalTime getOpeningHour()
    {
        return getTimetable().values().stream()
            .map(TimeInterval::getFirst)
            .min(LocalTime::compareTo)
            .orElse(null);
    }
    default LocalTime getClosingHour()
    {
        return getTimetable().values().stream()
                .map(TimeInterval::getSecond)
                .min(LocalTime::compareTo)
                .orElse(null);
    }
    default Duration getDurationAttraction(DayOfWeek day) {
        TimeInterval interval = getTimetable().get(day);
        if (interval != null) {
            return Duration.between(interval.getFirst(), interval.getSecond());
        } else {
            return Duration.ZERO;
        }

    }

}