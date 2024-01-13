import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static boolean isValidClientName(String clientName) {
        // Validate that the client name does not contain numbers
        return !Pattern.compile("[0-9]").matcher(clientName).find();
    }

    public static boolean isValidClientAge(String clientAge) {
        // Validate that the client age is a valid integer
        try {
            int age = Integer.parseInt(clientAge);
            return age >= 18; // Age should be a positive integer and higher than 18 (majority)
        } catch (NumberFormatException e) {
            System.err.println("Client Age must be an integer: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception error occurred in the code: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // Load library data from file
        store.setClients(Database.loadFromFile());

        int choice;
        do {
            System.out.println("\nLibrary Management System");

            String choices[] = { "Add Client", "Buy Vehicles", "Display Clients",
                "Display All Vehicles", "Display Client's Vehicles", "Exit" };

            try {
                for (int i = 1; i <= choices.length; i++) {
                    System.out.println(i + ". " + choices[i - 1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Array index out of bounds when looping through choices array: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Exception error occurred in the code: " + e.getMessage());
            }

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    if (isValidClientName(clientName) == false) {
                        System.out.println("Invalid client name. Please enter a valid name without numbers.");
                        continue;
                    }
                    System.out.print("Enter Client Age: ");
                    String clientAge = scanner.nextLine();
                    if (isValidClientAge(clientAge) == false) {
                        System.out.println("Invalid client age. Age should be a positive integer and higher than 18 (majority).");
                        continue;
                    }
                    System.out.print("Enter Client Nationality: ");
                    String clientNationality = scanner.nextLine();
                    store.addClient(new Client(clientName, Integer.parseInt(clientAge), clientNationality));
                    break;
                case 2:
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
                    store.displayClients();
                    break;
                case 4:
                    store.displayVehicles();
                    break;
                case 5:
                    store.displayClients();
                    System.out.print("Enter Client ID: ");
                    clientId = scanner.nextLine();
                    store.displayClientByID(store.findClientById(clientId));
                    break;
                case 6:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }

        } while (choice != 6);

        // Save library data to file before exiting
        Database.saveToFile(store.getClients());

        scanner.close();
    }
}
