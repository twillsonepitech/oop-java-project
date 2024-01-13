public abstract class Vehicle {
    protected String id;
    protected String brand;
    protected String model;
    protected double price;

    public Vehicle(String id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Vehicle => {id='" + id + "', brand='" + brand + "', model='" + model + "', price='" + price + "'}\n";
    }
}
