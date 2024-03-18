import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trip {
    private LocalTime start;
    private LocalTime end;
    private List<Attraction> attractions = new ArrayList<>();


    public Trip(LocalTime start, LocalTime end, List<Attraction> attractions) {
        this.start = start;
        this.end = end;
        this.attractions = attractions;
    }
    /**
     * metoda care returnează o listă cu numele atracțiilor care sunt vizitabile și nu sunt plătibile
     * sortează mai întâi atracțiile în funcție de ora de deschidere
     */
    public List<String> getVisitableAndNotPayableAttractions() {
        List<String> result = new ArrayList<>();
        LocalTime current = LocalTime.MIN;
        attractions.sort(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHour()));
        for (Attraction attraction : attractions) {
            if ( attraction instanceof Visitable
                    && !(attraction instanceof Payable))
            {
                LocalTime openingHour = ((Visitable) attraction).getOpeningHour();
                result.add(attraction.getName() + " - Opening hour: " + openingHour + "->" + attraction.getCity());
                current = openingHour;
            }
        }
        return result;
    }

    public void sortAttractions() {
        Collections.sort(attractions);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Trip{" + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }
}