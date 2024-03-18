import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

        Church biserica1 = new Church("Notre-Dame","Paris");
        TimeInterval interval1 = new TimeInterval(LocalTime.of(9, 0),  LocalTime.of(12, 0));
        biserica1.addTimeInterval(interval1, "monday", "wednesday");

        Church biserica2 = new Church("Joan of Arc","Paris");
        TimeInterval interval2 = new TimeInterval(LocalTime.of(12, 0),  LocalTime.of(18, 0));
        biserica2.addTimeInterval(interval2, "monday", "tuesday", "wednesday");

        Concert concert = new Concert("The Beatles", "New York", 50.0);
        TimeInterval interval3 = new TimeInterval(LocalTime.of(8, 30),  LocalTime.of(14, 0));
        concert.addTimeInterval(interval3, "monday");

        Statue statuie1 = new Statue("Statue of Liberty", "New York");
        TimeInterval interval4 = new TimeInterval(LocalTime.of(13, 0),  LocalTime.of(16, 0));
        statuie1.addTimeInterval(interval4, "monday", "tuesday");

        Statue statuie2 = new Statue("Colosseum", "Italy");
        TimeInterval interval5 = new TimeInterval(LocalTime.of(17, 0),  LocalTime.of(22, 0));
        statuie2.addTimeInterval(interval5, "tuesday", "wednesday");

        System.out.println("-----Attractions-----");
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(biserica1);
        attractions.add(biserica2);
        attractions.add(concert);
        attractions.add(statuie1);
        attractions.add(statuie2);

        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
        System.out.println();

        System.out.println("-----Trip-----");
        Trip excursie = new Trip(LocalTime.of(9, 0),  LocalTime.of(22, 0),attractions);
        excursie.sortAttractions();//in ordine alfabetica
        excursie.getVisitableAndNotPayableAttractions();

        List<String> listaTrip = excursie.getVisitableAndNotPayableAttractions();
        for (String attraction : listaTrip) {
            System.out.println(attraction);
        }
        System.out.println();

        System.out.println("-----Travel-----");
        TravelPlan planul = new TravelPlan(attractions);
        planul.createPlan();
    }
}