public abstract class Attraction
        implements Comparable<Attraction> {
    private String name;
    //… constructors, getters, setters
    //… toString, etc.
    @Override
    public int compareTo(Attraction other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }
}