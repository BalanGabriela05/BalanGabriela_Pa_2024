import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.Map;

public class Church implements Visitable, Location {
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return null;
    }

    @Override
    public int getLineNumber() {
        return 0;
    }

    @Override
    public int getColumnNumber() {
        return 0;
    }

    @Override
    public int getCharacterOffset() {
        return 0;
    }

    @Override
    public String getPublicId() {
        return null;
    }

    @Override
    public String getSystemId() {
        return null;
    }
}
