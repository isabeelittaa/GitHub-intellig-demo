public class Medicine {
    private String name;
    private double price;

    public Medicine(String name, double price) {
        this.name = name;
        setPrice(price);
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Validation Error: Price must be positive.");
            this.price = 1.0;
        }
    }
    
    @Override
    public String toString() { return "Medicine: " + name + " ($" + price + ")"; }
}