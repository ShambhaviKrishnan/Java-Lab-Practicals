// Base class Vehicle
class Vehicle {
    protected String brand;
    protected String model;

    // Constructor
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Method to display vehicle info
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

// Derived class Car
class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    // Overridden method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("----------------------------------");
    }
}

// Derived class Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    // Constructor
    public Motorcycle(String brand, String model, boolean hasCarrier) {
        super(brand, model);
        this.hasCarrier = hasCarrier;
    }

    // Overridden method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
        System.out.println("----------------------------------");
    }
}

// Main class
public class ManageVehicles {
    public static void main(String[] args) {
        // Creating objects of derived classes
        Car car1 = new Car("Toyota", "Camry", 4);
        Motorcycle bike1 = new Motorcycle("Honda", "Shine", true);

        // Displaying information
        System.out.println("Car Information:");
        car1.displayInfo();

        System.out.println("Motorcycle Information:");
        bike1.displayInfo();
    }
}
