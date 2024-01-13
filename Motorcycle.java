public class Motorcycle extends Vehicle implements Purchasable {
    private String type;

    public Motorcycle(String id, String brand, String model, double price, String type) {
        super(id, brand, model, price);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public void purchase(Client client) {
        System.out.println(client.toString() + " purchased Motorcycle: " + this);
    }

    @Override
    public String toString() {
        return "Motorcycle " + super.toString() + ", type='" + type + "'}\n";
    }
}
