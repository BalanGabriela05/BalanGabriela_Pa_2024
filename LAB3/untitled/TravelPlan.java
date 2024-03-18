import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class TravelPlan {
    private List<Attraction> attractions ;

    public TravelPlan(List<Attraction> attractions) {
        this.attractions = attractions;
    }


    public void createPlan() {
        Map<DayOfWeek, List<Attraction>> plan = new LinkedHashMap<>();
        Set<Attraction> visitedAttractions = new HashSet<>();

        for (DayOfWeek day : DayOfWeek.values()) {
            List<Attraction> attractionsForDay = new ArrayList<>();
            LocalTime current = LocalTime.MIN;

/**
 * sortez lista de atracții în funcție de numărul de zile în care fiecare atracție este disponibilă, ora de deschidere și durata atracției
 */
            attractions.sort(Comparator.comparing((Attraction attraction) -> ((Visitable) attraction).getTimetable().size())
                    .thenComparing((Attraction attraction) -> ((Visitable) attraction).getOpeningHour())
                    .thenComparing(attraction -> ((Visitable) attraction).getDurationAttraction(day)));
/**
 * dacă atracția nu a fost deja vizitată, este vizitabilă, este disponibilă în ziua curentă și ora de deschidere este după ora curentă
 * atunci atracția este adăugată la lista de atracții pentru ziua curentă
 * ora curentă este actualizată la ora de închidere a atracției
 */

            for (Attraction attraction : attractions) {
                if (!visitedAttractions.contains(attraction)
                        && attraction instanceof Visitable
                        && ((Visitable) attraction).getTimetable().containsKey(day)
                        && (current.isBefore(((Visitable) attraction).getOpeningHour())
                        || current.equals(((Visitable) attraction).getOpeningHour()))) {
                    attractionsForDay.add(attraction);
                    visitedAttractions.add(attraction);
                    LocalTime closingHour = ((Visitable) attraction).getClosingHour();
                    current = closingHour;
                }
            }


            plan.put(day, attractionsForDay);
        }

        //Print TravelPlan
        for (Map.Entry<DayOfWeek, List<Attraction>> entry : plan.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                String attractionsList = entry.getValue().stream()
                        .map(attraction -> attraction.getName() + " (" + ((Visitable) attraction).getOpeningHour() + "-" + ((Visitable) attraction).getClosingHour() + ")")
                        .collect(Collectors.joining(", "));
                System.out.println(entry.getKey() + ": " + attractionsList);
            }
        }
    }



}
