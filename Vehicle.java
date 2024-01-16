/**
 * The Vehicle class is an abstract class representing a generic vehicle.
 * It implements the Purchasable interface, indicating that vehicles can be purchased.
 */
public abstract class Vehicle implements Purchasable {
    // Protected fields to store common attributes of all vehicles.
    protected String id;
    protected String brand;
    protected String model;
    protected double price;

    /**
     * Constructor for creating a Vehicle object with specified attributes.
     *
     * @param id    The unique identifier of the vehicle.
     * @param brand The brand of the vehicle.
     * @param model The model of the vehicle.
     * @param price The price of the vehicle.
     */
    public Vehicle(String id, String brand, String model, double price) {
        // Initialize common attributes of all vehicles.
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     * Getter method to retrieve the unique identifier of the vehicle.
     *
     * @return The unique identifier of the vehicle.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Getter method to retrieve the brand of the vehicle.
     *
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Getter method to retrieve the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Getter method to retrieve the price of the vehicle.
     *
     * @return The price of the vehicle.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter method to update the unique identifier of the vehicle.
     *
     * @param id The new unique identifier of the vehicle.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter method to update the brand of the vehicle.
     *
     * @param brand The new brand of the vehicle.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Setter method to update the model of the vehicle.
     *
     * @param model The new model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setter method to update the price of the vehicle.
     *
     * @param price The new price of the vehicle.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Overrides the toString method to provide a string representation of the Vehicle object.
     *
     * @return A string representation of the Vehicle.
     */
    @Override
    public String toString() {
        return "Vehicle => {id='" + id + "', brand='" + brand + "', model='" + model + "', price='" + price + "'}\n";
    }
}
