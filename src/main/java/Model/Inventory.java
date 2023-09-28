package Model;

public class Inventory {
    private String item;
    private double price;
    private int quantity;


    public Inventory(){

    }
    public Inventory(String item, double price, int quantity){
        this.item = item;
        this.price= price;
        this.quantity = quantity;
    }
    public Inventory(String item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
