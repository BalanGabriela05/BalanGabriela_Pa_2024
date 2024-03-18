//In Payable.java
public interface Payable {
    double getTicketPrice();
    default boolean isPayable(){
      return isPayable();
    }
}
