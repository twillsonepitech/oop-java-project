/**
 * The Car class represents a specific type of Vehicle, inheriting from the Vehicle class.
 */
public class Car extends Vehicle {
    // Private field to store the number of doors in the car.
    private int numberOfDoors;

    /**
     * Constructor for creating a Car object with specified attributes.
     *
     * @param id            The unique identifier of the car.
     * @param brand         The brand of the car.
     * @param model         The model of the car.
     * @param price         The price of the car.
     * @param numberOfDoors The number of doors in the car.
     */
    public Car(String id, String brand, String model, double price, int numberOfDoors) {
        // Call the constructor of the superclass (Vehicle) to initialize common attributes.
        super(id, brand, model, price);
        // Set the number of doors specific to Car.
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Getter method to retrieve the number of doors in the car.
     *
     * @return The number of doors in the car.
     */
    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    /**
     * Setter method to update the number of doors in the car.
     *
     * @param numberOfDoors The new number of doors in the car.
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Overrides the purchase method from the Purchasable interface.
     * Outputs a message indicating the purchase of the car by a client.
     *
     * @param client The client making the purchase.
     */
    @Override
    public void purchase(Client client) {
        System.out.println(client.toString() + " purchased Car: " + this);
    }

    /**
     * Overrides the toString method to provide a string representation of the Car object.
     *
     * @return A string representation of the Car.
     */
    @Override
    public String toString() {
        return "Car " + super.toString() + ", numberOfDoors='" + numberOfDoors + "'}\n";
    }
}
