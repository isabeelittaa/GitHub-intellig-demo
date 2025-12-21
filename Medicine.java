public class Medicine {

    private String medicineId;
    private String name;
    private double price;
    private int stockQuantity;
    private boolean requiresPrescription;

    public Medicine(String medicineId, String name, double price, int stockQuantity, boolean requiresPrescription) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.requiresPrescription = requiresPrescription;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void dispense(int amount) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be positive.");
            return;
        }

        if (stockQuantity >= amount) {
            stockQuantity -= amount;
            System.out.println("Dispensed " + amount + " units of " + name + ". Remaining stock: " + stockQuantity);
        } else {
            System.out.println("Stock error: Not enough " + name + " available. Current stock: " + stockQuantity);
        }
    }

    public void applyDiscount(double percentOff) {
        if (percentOff > 0 && percentOff <= 100) {
            double discountAmount = price * (percentOff / 100);
            price -= discountAmount;
            System.out.println("Discount applied. New price for " + name + " is $" + price);
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }
}