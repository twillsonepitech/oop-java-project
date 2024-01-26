import java.util.ArrayList;
import java.util.List;

/**
 * The Store class represents a store that manages clients and vehicles.
 */
public class Store {
    // Lists to store clients and vehicles
    private List<Client> clients;
    private List<Vehicle> vehicles;

    /**
     * Constructor to initialize the Store with empty client and vehicle lists and generate initial vehicles.
     */
    public Store() {
        this.clients = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.generateVehicles();
    }

    /**
     * Getter method to retrieve the list of clients.
     *
     * @return The list of clients.
     */
    public List<Client> getClients() {
        return this.clients;
    }

    /**
     * Getter method to retrieve the list of vehicles.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Setter method to update the list of clients.
     *
     * @param clients The new list of clients.
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Setter method to update the list of vehicles.
     *
     * @param vehicles The new list of vehicles.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Private method to generate initial vehicles and add them to the vehicles list.
     */
    private void generateVehicles() {
        // Adding Cars to Vehicles array
        this.vehicles.add(new Car("701cede8-c5b0-4a65-9397-138c444dd475", "Toyota", "Camry", 25000.0, 4));
        this.vehicles.add(new Car("4af13c4c-ff2d-4b38-a49d-8c52b3dbd47c", "Honda", "Accord", 28000.0, 4));
        this.vehicles.add(new Car("4532601b-3db1-4252-a4c4-4c4786f56732", "Ford", "Mustang", 40000.0, 2));
        this.vehicles.add(new Car("592896b8-d8c1-4902-b7b4-dd5506fa0696", "Chevrolet", "Malibu", 26000.0, 4));
        this.vehicles.add(new Car("9b6985c4-919f-4d66-8efb-71f728ef10e6", "Nissan", "Altima", 27000.0, 4));

        // Adding Motorcycles to Vehicles array
        this.vehicles.add(new Motorcycle("150297c9-ed6d-4482-9b1a-1098604efded", "Harley-Davidson", "Sportster", 12000.0, "Cruiser"));
        this.vehicles.add(new Motorcycle("3c5e114d-a17b-4c9c-a191-e3be2f2ae202", "Honda", "CBR600RR", 11000.0, "Sport"));
        this.vehicles.add(new Motorcycle("13ee1120-a884-464d-947f-1bf570395767", "Yamaha", "MT-09", 9500.0, "Naked"));
        this.vehicles.add(new Motorcycle("5c04f3dd-478e-43fa-8f41-afd06ae7a763", "Kawasaki", "Ninja 650", 9000.0, "Sport Touring"));
        this.vehicles.add(new Motorcycle("d643ae20-9292-4fd2-9d5f-7a77f23287c1", "Ducati", "Monster 821", 13000.0, "Standard"));
    }

    /**
     * Method to add a client to the list of clients.
     *
     * @param client The client to be added.
     */
    public void addClient(Client client) {
        this.clients.add(client);
        System.out.println("\n New client has been added :" + client);
    }

    /**
     * Method to display the list of clients.
     */
    public void displayClients() {
        System.out.println("\nClients :");
        clients.forEach(System.out::println);
    }

    /**
     * Method to display the list of vehicles.
     */
    public void displayVehicles() {
        System.out.println("\nVehicles :");
        vehicles.forEach(System.out::println);
    }

    /**
     * Method to display the vehicles owned by a specific client.
     *
     * @param client The client whose vehicles are to be displayed.
     */
    public void displayClientByID(Client client) {
        if (client != null) {
            System.out.println();
            client.getVehicles().forEach(System.out::println);
        } else {
            System.out.println("Invalid client ID. Please enter an existing client ID.");
        }
    }

    /**
     * Method to purchase a vehicle for a specific client.
     *
     * @param vehicleId The ID of the vehicle to be purchased.
     * @param clientId  The ID of the client making the purchase.
     */
    public void purchaseVehicle(String vehicleId, String clientId) {
        Vehicle vehicle = this.findVehicleById(vehicleId);
        Client client = this.findClientById(clientId);

        if (vehicle != null && client != null && vehicle instanceof Purchasable) {
            ((Purchasable) vehicle).purchase(client);
            client.buyVehicle(vehicle);
        } else {
            System.out.println("Invalid vehicle or client ID or the vehicle is not purchasable.");
        }
    }

    /**
     * Method to find a vehicle by its ID.
     *
     * @param vehicleId The ID of the vehicle to find.
     * @return The found vehicle or null if not found.
     */
    public Vehicle findVehicleById(String vehicleId) {
        return this.vehicles.stream().filter(v -> v.getId().equals(vehicleId)).findFirst().orElse(null);
    }

    /**
     * Method to find a client by their ID.
     *
     * @param clientId The ID of the client to find.
     * @return The found client or null if not found.
     */
    public Client findClientById(String clientId) {
        return this.clients.stream().filter(c -> c.getClientId().equals(clientId)).findFirst().orElse(null);
    }
}
