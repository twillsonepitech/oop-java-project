public class Car extends Vehicle implements Purchasable {
    private int numberOfDoors;

    public Car(String id, String brand, String model, double price, int numberOfDoors) {
        super(id, brand, model, price);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void purchase(Client client) {
        System.out.println(client.toString() + " purchased Car: " + this);
    }

    @Override
    public String toString() {
        return "Car " + super.toString() + ", numberOfDoors='" + numberOfDoors + "'}\n";
    }
}
