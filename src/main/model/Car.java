
public class Car {
    private String carId;
    private String brand;
    private String model;
    private double dailyRate;
    private boolean isAvailable;
    
    public Car(String carId, String brand, String model, double dailyRate) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }
    
    public String getCarId() {
        return carId;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    @Override
    public String toString() {
        return String.format("Car[ID: %s, %s %s, Rate: $%.2f/day, Available: %s]", 
                           carId, brand, model, dailyRate, isAvailable ? "Yes" : "No");
    }
}
