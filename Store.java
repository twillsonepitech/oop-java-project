import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Client> clients;
    private List<Vehicle> vehicles;

    public Store() {
        this.clients = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.generateVehicles();
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void generateVehicles() {
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

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void displayClients() {
        System.out.println("\nClients :");
        clients.forEach(System.out::println);
    }

    public void displayVehicles() {
        System.out.println("\nVehicles :");
        vehicles.forEach(System.out::println);
    }

    public void displayClientByID(Client client) {
        if (client != null) {
            System.out.println();
            client.getVehicles().forEach(System.out::println);
        } else {
            System.out.println("Invalid client ID. Please enter an existing client ID.");
        }
    }

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

    public Vehicle findVehicleById(String vehicleId) {
        return this.vehicles.stream().filter(v -> v.getId().equals(vehicleId)).findFirst().orElse(null);
    }

    public Client findClientById(String clientId) {
        return this.clients.stream().filter(c -> c.getClientId().equals(clientId)).findFirst().orElse(null);
    }
}
