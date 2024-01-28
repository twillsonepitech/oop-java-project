import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Define constants for the minimum / maximum age required to be a client
    private static final int MINIMUM_AGE = 18;
    private static final int MAXIMUM_AGE = 100;

    /**
     * Check if a given client name is valid
     * 
     * @param clientName the name of the client to check
     * @return true if the name is valid, false otherwise
     */
    private static boolean isValidClientName(String clientName) {
        // Validate that the client name does not contain numbers
        return !Pattern.compile("[0-9]").matcher(clientName).find();
    }

    /**
     * Check if a given client age is valid
     * 
     * @param clientAge the age of the client to check
     * @return true if the age is valid, false otherwise
     */
    private static boolean isValidClientAge(String clientAge) {
        // Validate that the client age is a valid integer
        try {
            int age = Integer.parseInt(clientAge);
            return age >= MINIMUM_AGE && age <= MAXIMUM_AGE; // Age should be a positive integer, higher than 18 (majority)
        } catch (NumberFormatException e) {
            System.err.println("Client Age must be an integer: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception error occurred in the code: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a new Store object
        Store store = new Store();
        // Create a new Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Load library data from file
        store.setClients(Database.loadFromFile());

        int choice = 0;
        do {
            // Print the main menu to the console
            System.out.println("\nLibrary Management System");
            String choices[] = { "Add Client", "Buy Vehicles", "Display Clients",
                "Display All Vehicles", "Display Client's Vehicles", "Exit" };
            // Print the menu options to the console
            try {
                for (int i = 1; i <= choices.length; i++) {
                    System.out.println(i + ". " + choices[i - 1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Array index out of bounds when looping through choices array: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Exception error occurred in the code: " + e.getMessage());
            }

            // Prompt the user to enter their choice
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Choice must be a number between 1 and 6: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Exception error occurred in the code: " + e.getMessage());
            } finally {
                scanner.nextLine(); // Consume the newline character
            }

            // Handle the user's choice
            switch (choice) {
                case 1:
                    // Add a new client
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    if (isValidClientName(clientName) == false) {
                        System.out.println("Invalid client name. Please enter a valid name without numbers.");
                        continue;
                    }
                    System.out.print("Enter Client Age: ");
                    String clientAge = scanner.nextLine();
                    if (isValidClientAge(clientAge) == false) {
                        System.out.println("Invalid client age. Age should be a positive integer, older than 18 years old (majority) and younger than 100 years old.");
                        continue;
                    }
                    System.out.print("Enter Client Nationality: ");
                    String clientNationality = scanner.nextLine();
                    store.addClient(new Client(clientName, Integer.parseInt(clientAge), clientNationality));
                    break;
                case 2:
                    // Buy a vehicle for a client
                    store.displayClients();
                    System.out.print("Enter Client ID: ");
                    String clientId = scanner.nextLine();
                    if (store.findClientById(clientId) == null) {
                        System.out.println("Invalid client ID. Please enter an existing client ID.");
                        continue;
                    }
                    store.displayVehicles();
                    System.out.print("Enter Vehicle ID: ");
                    String vehicleId = scanner.nextLine();
                    if (store.findVehicleById(vehicleId) == null) {
                        System.out.println("Invalid vehicle ID. Please enter an existing vehicle ID.");
                        continue;
                    }
                    store.purchaseVehicle(vehicleId, clientId);
                    break;
                case 3:
                    // Display all clients
                    store.displayClients();
                    break;
                case 4:
                    // Display all vehicles
                    store.displayVehicles();
                    break;
                case 5:
                    // Display a client's vehicles
                    store.displayClients();
                    System.out.print("Enter Client ID: ");
                    clientId = scanner.nextLine();
                    store.displayClientByID(store.findClientById(clientId));
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }

        } while (choice != 6);

        // Save library data to file before exiting
        Database.saveToFile(store.getClients());

        // Close the Scanner object
        scanner.close();
    }
}