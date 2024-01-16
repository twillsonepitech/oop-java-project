/**
 * The Motorcycle class represents a specific type of Vehicle, inheriting from the Vehicle class.
 */
public class Motorcycle extends Vehicle {
    // Private field to store the type of the motorcycle.
    private String type;

    /**
     * Constructor for creating a Motorcycle object with specified attributes.
     *
     * @param id    The unique identifier of the motorcycle.
     * @param brand The brand of the motorcycle.
     * @param model The model of the motorcycle.
     * @param price The price of the motorcycle.
     * @param type  The type of the motorcycle (e.g., Cruiser, Sport, Naked).
     */
    public Motorcycle(String id, String brand, String model, double price, String type) {
        // Call the constructor of the superclass (Vehicle) to initialize common attributes.
        super(id, brand, model, price);
        // Set the type specific to Motorcycle.
        this.type = type;
    }

    /**
     * Getter method to retrieve the type of the motorcycle.
     *
     * @return The type of the motorcycle.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Setter method to update the type of the motorcycle.
     *
     * @param type The new type of the motorcycle.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Overrides the purchase method from the Purchasable interface.
     * Outputs a message indicating the purchase of the motorcycle by a client.
     *
     * @param client The client making the purchase.
     */
    @Override
    public void purchase(Client client) {
        System.out.println(client.toString() + " purchased Motorcycle: " + this);
    }

    /**
     * Overrides the toString method to provide a string representation of the Motorcycle object.
     *
     * @return A string representation of the Motorcycle.
     */
    @Override
    public String toString() {
        return "Motorcycle " + super.toString() + ", type='" + type + "'}\n";
    }
}
