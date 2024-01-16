import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Database class for saving and loading client data to/from a JSON file
public class Database {

    private static final String FILE_NAME = "database.json";  // Name of the JSON file

    /**
     * Save a list of clients to the JSON file
     * 
     * @param clients The list of clients with their respective datas
     */
    public static void saveToFile(List<Client> clients) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Create a JSON object to store clients
            JSONObject jsonData = new JSONObject();

            // Create a JSON array for clients
            if (!clients.isEmpty()) {
                JSONArray clientsArray = new JSONArray();
                for (Client client : clients) {
                    JSONObject clientObject = new JSONObject();
                    clientObject.put("clientId", client.getClientId());
                    clientObject.put("clientName", client.getClientName());
                    clientObject.put("clientAge", client.getClientAge());
                    clientObject.put("clientNationality", client.getClientNationality());

                    // Include information about vehicles for each client
                    JSONArray vehiclesArray = new JSONArray();
                    for (Vehicle vehicle : client.getVehicles()) {
                        JSONObject vehicleObject = new JSONObject();
                        vehicleObject.put("vehicleId", vehicle.getId());
                        vehicleObject.put("brand", vehicle.getBrand());
                        vehicleObject.put("model", vehicle.getModel());
                        vehicleObject.put("price", vehicle.getPrice());

                        // Include additional details for Car or Motorcycle
                        if (vehicle instanceof Car) {
                            Car car = (Car) vehicle;
                            vehicleObject.put("numberOfDoors", car.getNumberOfDoors());
                        } else if (vehicle instanceof Motorcycle) {
                            Motorcycle motorcycle = (Motorcycle) vehicle;
                            vehicleObject.put("type", motorcycle.getType());
                        }

                        vehiclesArray.put(vehicleObject);
                    }
                    clientObject.put("vehicles", vehiclesArray);
                    clientsArray.put(clientObject);
                }
                jsonData.put("clients", clientsArray);
            } else {
                jsonData.put("clients", new JSONArray());
            }
            // Write the JSON object to the file with indentation
            writer.println(jsonData.toString(2));

        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    /**
     * Load a list of clients from the JSON file
     * 
     * @return All the clients retrieved from the database file
     */
    public static List<Client> loadFromFile() {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;

            // Read the entire JSON content from the file
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            // If the file is empty or doesn't contain valid JSON, create an empty file
            if (jsonContent.length() == 0) {
                createEmptyFile();
                return clients;
            }

            // Parse JSON content
            JSONObject jsonData = new JSONObject(jsonContent.toString());

            // Parse clients
            JSONArray clientsArray = jsonData.getJSONArray("clients");
            for (int i = 0; i < clientsArray.length(); i++) {
                JSONObject clientObject = clientsArray.getJSONObject(i);
                String clientId = clientObject.getString("clientId");
                String clientName = clientObject.getString("clientName");
                int clientAge = clientObject.getInt("clientAge");
                String clientNationality = clientObject.getString("clientNationality");

                // Parse and print vehicles
                JSONArray vehiclesArray = clientObject.getJSONArray("vehicles");
                List<Vehicle> vehicles = new ArrayList<>();
                for (int j = 0; j < vehiclesArray.length(); j++) {
                    JSONObject vehicleObject = vehiclesArray.getJSONObject(j);
                    String vehicleId = vehicleObject.getString("vehicleId");
                    String brand = vehicleObject.getString("brand");
                    String model = vehicleObject.getString("model");
                    double price = vehicleObject.getDouble("price");

                    // Additional details for Car or Motorcycle
                    if (vehicleObject.has("numberOfDoors")) {
                        int numberOfDoors = vehicleObject.getInt("numberOfDoors");
                        vehicles.add(new Car(vehicleId, brand, model, price, numberOfDoors));
                    } else if (vehicleObject.has("type")) {
                        String type = vehicleObject.getString("type");
                        vehicles.add(new Motorcycle(vehicleId, brand, model, price, type));
                    }
                }

                clients.add(new Client(clientId, clientName, clientAge, clientNationality, vehicles));
            }

        } catch (FileNotFoundException e) {
            createEmptyFile();
        } catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }

        return clients;
    }

    /**
     * Create an empty JSON file
     */
    private static void createEmptyFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Create an empty JSON object
            JSONObject jsonData = new JSONObject();
            jsonData.put("clients", new JSONArray());

            // Write the JSON object to the file with indentation
            writer.println(jsonData.toString(2));

        } catch (IOException e) {
            System.err.println("Error creating an empty file: " + e.getMessage());
        }
    }
}
