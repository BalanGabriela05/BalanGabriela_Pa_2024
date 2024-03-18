import java.time.LocalTime;

class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }
    public LocalTime getFirst() {
        return super.getFirst();
    }
    public LocalTime getSecond() {
        return super.getSecond();
    }

}