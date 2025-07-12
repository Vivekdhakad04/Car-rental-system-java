
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rental {
    private String rentalId;
    private String carId;
    private String customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int rentalDays;
    private double totalCost;
    private boolean isReturned;
    
    public Rental(String rentalId, String carId, String customerId, int rentalDays, double totalCost) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerId = customerId;
        this.rentalDays = rentalDays;
        this.totalCost = totalCost;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(rentalDays);
        this.isReturned = false;
    }
    
    public String getRentalId() {
        return rentalId;
    }
    
    public String getCarId() {
        return carId;
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public int getRentalDays() {
        return rentalDays;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public boolean isReturned() {
        return isReturned;
    }
    
    public void setReturned(boolean returned) {
        this.isReturned = returned;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Rental[ID: %s, Car: %s, Customer: %s, Start: %s, End: %s, Days: %d, Cost: $%.2f, Returned: %s]",
                           rentalId, carId, customerId, 
                           startDate.format(formatter), endDate.format(formatter),
                           rentalDays, totalCost, isReturned ? "Yes" : "No");
    }
}
