package model;
import exception.InvalidHospitalDataException;
public class Medicine {
    private String name;
    private double price;
    private int stock;

    public Medicine(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setPrice(double price) throws InvalidHospitalDataException {
        if (price < 0) throw new InvalidHospitalDataException("Price cannot be negative.");
        this.price = price;
    }

    public void setStock(int stock) throws InvalidHospitalDataException {
        if (stock < 0) throw new InvalidHospitalDataException("Stock cannot be negative.");
        this.stock = stock;
    }


    public void dispense(int amount) {
        if (stock >= amount) {
            stock -= amount;
            System.out.println("Dispensed " + amount + " of " + name);
        }
    }

    public void applyDiscount(double percent) {
        price -= price * percent / 100;
        System.out.println("New price: $" + price);
    }

    @Override
    public String toString() {
        return "Medicine " + name + " ($" + price + ", Stock=" + stock + ")";
    }
}