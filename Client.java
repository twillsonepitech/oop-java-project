import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Client class represents a client who can buy and sell vehicles.
 */
public class Client {
    // Unique identifier for the client
    private String clientId;

    // Client's name, age, and nationality
    private String clientName;
    private int clientAge;
    private String clientNationality;

    // List to store vehicles owned by the client
    private List<Vehicle> vehicles;

    /**
     * Constructor to create a new client with a randomly generated client ID.
     *
     * @param clientName         The name of the client.
     * @param clientAge          The age of the client.
     * @param clientNationality The nationality of the client.
     */
    public Client(String clientName, int clientAge, String clientNationality) {
        this.clientId = UUID.randomUUID().toString();
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientNationality = clientNationality;
        this.vehicles = new ArrayList<>();
    }

    /**
     * Constructor to create a client with a specified client ID and other details.
     *
     * @param clientId           The unique identifier for the client.
     * @param clientName         The name of the client.
     * @param clientAge          The age of the client.
     * @param clientNationality The nationality of the client.
     * @param vehicles           The list of vehicles owned by the client.
     */
    public Client(String clientId, String clientName, int clientAge, String clientNationality, List<Vehicle> vehicles) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientNationality = clientNationality;
        this.vehicles = vehicles;
    }

    /**
     * Getter method to retrieve the client's unique identifier.
     *
     * @return The client's unique identifier.
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * Getter method to retrieve the client's name.
     *
     * @return The client's name.
     */
    public String getClientName() {
        return this.clientName;
    }

    /**
     * Getter method to retrieve the client's age.
     *
     * @return The client's age.
     */
    public int getClientAge() {
        return this.clientAge;
    }

    /**
     * Getter method to retrieve the client's nationality.
     *
     * @return The client's nationality.
     */
    public String getClientNationality() {
        return this.clientNationality;
    }

    /**
     * Getter method to retrieve the list of vehicles owned by the client.
     *
     * @return The list of vehicles owned by the client.
     */
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Setter method to update the client's unique identifier.
     *
     * @param clientId The new client ID.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Setter method to update the client's name.
     *
     * @param clientName The new client name.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Setter method to update the client's age.
     *
     * @param clientAge The new client age.
     */
    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    /**
     * Setter method to update the client's nationality.
     *
     * @param clientNationality The new client nationality.
     */
    public void setClientNationality(String clientNationality) {
        this.clientNationality = clientNationality;
    }

    /**
     * Setter method to update the list of vehicles owned by the client.
     *
     * @param vehicles The new list of vehicles.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Method to display the client's details as a string.
     *
     * @return A string representation of the client.
     */
    @Override
    public String toString() {
        return "Client => {clientId='" + this.clientId + "', clientName='" + this.clientName
                + ", clientAge='" + this.clientAge + ", clientNationality='" + this.clientNationality
                + "', Vehicles=" + this.vehicles + "}\n";
    }

    /**
     * Method for the client to buy a vehicle and add it to their list of owned vehicles.
     *
     * @param vehicle The vehicle to be bought.
     */
    public void buyVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    /**
     * Method for the client to sell a vehicle and remove it from their list of owned vehicles.
     *
     * @param vehicle The vehicle to be sold.
     */
    public void sellVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
}
