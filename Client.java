import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private String clientId;
    private String clientName;
    private int clientAge;
    private String clientNationality;
    private List<Vehicle> vehicles;

    public Client(String clientName, int clientAge, String clientNationality) {
        this.clientId = UUID.randomUUID().toString();
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientNationality = clientNationality;
        this.vehicles = new ArrayList<>();
    }

    public Client(String clientId, String clientName, int clientAge, String clientNationality, List<Vehicle> vehicles) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientNationality = clientNationality;
        this.vehicles = vehicles;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public int getClientAge() {
        return this.clientAge;
    }

    public String getClientNationality() {
        return this.clientNationality;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public void setClientNationality(String clientNationality) {
        this.clientNationality = clientNationality;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Client => {clientId='" + this.clientId + "', clientName='" + this.clientName
        + ", clientAge='" + this.clientAge + ", clientNationality='" + this.clientNationality
        + "', Vehicles=" + this.vehicles + "}\n";
    }

    public void buyVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void sellVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
}
