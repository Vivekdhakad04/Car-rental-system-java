
import java.util.*;

public class Main {
    private static CarRentalSystem rentalSystem = new CarRentalSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to Car Rental System ===");
        
        // Initialize with some sample data
        initializeSampleData();
        
        while (true) {
            showMainMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    viewAvailableCars();
                    break;
                case 2:
                    rentCar();
                    break;
                case 3:
                    returnCar();
                    break;
                case 4:
                    viewRentalHistory();
                    break;
                case 5:
                    addNewCar();
                    break;
                case 6:
                    addNewCustomer();
                    break;
                case 7:
                    System.out.println("Thank you for using Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n=== Car Rental System Menu ===");
        System.out.println("1. View Available Cars");
        System.out.println("2. Rent a Car");
        System.out.println("3. Return a Car");
        System.out.println("4. View Rental History");
        System.out.println("5. Add New Car");
        System.out.println("6. Add New Customer");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void viewAvailableCars() {
        System.out.println("\n=== Available Cars ===");
        List<Car> availableCars = rentalSystem.getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("No cars available for rent.");
        } else {
            for (Car car : availableCars) {
                System.out.println(car);
            }
        }
    }
    
    private static void rentCar() {
        System.out.println("\n=== Rent a Car ===");
        
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        
        Customer customer = rentalSystem.findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Please add customer first.");
            return;
        }
        
        viewAvailableCars();
        System.out.print("Enter car ID to rent: ");
        String carId = scanner.nextLine();
        
        System.out.print("Enter rental days: ");
        int days = getIntInput();
        
        boolean success = rentalSystem.rentCar(carId, customerId, days);
        if (success) {
            System.out.println("Car rented successfully!");
            Car car = rentalSystem.findCar(carId);
            double totalCost = car.getDailyRate() * days;
            System.out.println("Total cost: $" + totalCost);
        } else {
            System.out.println("Failed to rent car. Car may not be available.");
        }
    }
    
    private static void returnCar() {
        System.out.println("\n=== Return a Car ===");
        
        System.out.print("Enter rental ID: ");
        String rentalId = scanner.nextLine();
        
        boolean success = rentalSystem.returnCar(rentalId);
        if (success) {
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Rental not found or car already returned.");
        }
    }
    
    private static void viewRentalHistory() {
        System.out.println("\n=== Rental History ===");
        List<Rental> rentals = rentalSystem.getAllRentals();
        if (rentals.isEmpty()) {
            System.out.println("No rental history found.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental);
            }
        }
    }
    
    private static void addNewCar() {
        System.out.println("\n=== Add New Car ===");
        
        System.out.print("Enter car ID: ");
        String carId = scanner.nextLine();
        
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        
        System.out.print("Enter daily rental rate: $");
        double rate = getDoubleInput();
        
        Car car = new Car(carId, brand, model, rate);
        rentalSystem.addCar(car);
        System.out.println("Car added successfully!");
    }
    
    private static void addNewCustomer() {
        System.out.println("\n=== Add New Customer ===");
        
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();
        
        Customer customer = new Customer(customerId, name, phone);
        rentalSystem.addCustomer(customer);
        System.out.println("Customer added successfully!");
    }
    
    private static int getIntInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
    
    private static double getDoubleInput() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
    
    private static void initializeSampleData() {
        // Add sample cars
        rentalSystem.addCar(new Car("C001", "Toyota", "Camry", 50.0));
        rentalSystem.addCar(new Car("C002", "Honda", "Accord", 55.0));
        rentalSystem.addCar(new Car("C003", "BMW", "X3", 80.0));
        rentalSystem.addCar(new Car("C004", "Mercedes", "C-Class", 90.0));
        
        // Add sample customers
        rentalSystem.addCustomer(new Customer("CUST001", "John Doe", "123-456-7890"));
        rentalSystem.addCustomer(new Customer("CUST002", "Jane Smith", "987-654-3210"));
    }
}
