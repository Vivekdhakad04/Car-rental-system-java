
import java.util.*;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    private int rentalCounter;
    
    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.rentalCounter = 1;
    }
    
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }
    
    public Car findCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
    
    public Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public boolean rentCar(String carId, String customerId, int rentalDays) {
        Car car = findCar(carId);
        Customer customer = findCustomer(customerId);
        
        if (car != null && customer != null && car.isAvailable()) {
            car.setAvailable(false);
            String rentalId = "R" + String.format("%03d", rentalCounter++);
            double totalCost = car.getDailyRate() * rentalDays;
            
            Rental rental = new Rental(rentalId, carId, customerId, rentalDays, totalCost);
            rentals.add(rental);
            
            return true;
        }
        return false;
    }
    
    public boolean returnCar(String rentalId) {
        for (Rental rental : rentals) {
            if (rental.getRentalId().equals(rentalId) && !rental.isReturned()) {
                rental.setReturned(true);
                
                Car car = findCar(rental.getCarId());
                if (car != null) {
                    car.setAvailable(true);
                }
                
                return true;
            }
        }
        return false;
    }
    
    public List<Rental> getAllRentals() {
        return new ArrayList<>(rentals);
    }
    
    public List<Rental> getActiveRentals() {
        List<Rental> activeRentals = new ArrayList<>();
        for (Rental rental : rentals) {
            if (!rental.isReturned()) {
                activeRentals.add(rental);
            }
        }
        return activeRentals;
    }
}
