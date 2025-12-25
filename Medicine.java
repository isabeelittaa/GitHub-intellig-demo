public class Medicine {
    // 1. Private fields (4+)
    private String medicineId;
    private String name;
    private double price;
    private int stockQuantity;
    private boolean requiresPrescription;

    // 2a. Parameterized Constructor
    public Medicine(String medicineId, String name, double price, int stockQuantity, boolean requiresPrescription) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.requiresPrescription = requiresPrescription;
    }

    // 2b. Default Constructor (REQUIRED BY RUBRIC)
    public Medicine() {
    }

    // 3. Getters and Setters for ALL fields (REQUIRED BY RUBRIC)
    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public boolean isRequiresPrescription() { return requiresPrescription; }
    public void setRequiresPrescription(boolean requiresPrescription) { this.requiresPrescription = requiresPrescription; }

    // 4. Methods with Business Logic
    public void dispense(int amount) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be positive.");
            return;
        }
        if (stockQuantity >= amount) {
            stockQuantity -= amount;
            System.out.println("Dispensed " + amount + " units of " + name + ". Remaining stock: " + stockQuantity);
        } else {
            System.out.println("Stock error: Not enough " + name + " available.");
        }
    }

    public void applyDiscount(double percentOff) {
        if (percentOff > 0 && percentOff <= 100) {
            double discountAmount = price * (percentOff / 100);
            this.price -= discountAmount;
            System.out.println("Discount applied. New price for " + name + " is $" + this.price);
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }

    // 5. toString Method (REQUIRED BY RUBRIC)
    @Override
    public String toString() {
        return "Medicine [ID=" + medicineId + ", Name=" + name + ", Price=" + price + ", Stock=" + stockQuantity + "]";
    }
}