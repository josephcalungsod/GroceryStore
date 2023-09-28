package Model;

public class Inventory {
    private String item;
    private double price;
    private int quantity;
    private String type;


    public Inventory(){

    }

    /**
     *
     * @param item
     * @param price
     * @param quantity
     */
    public Inventory(String item, String type, double price, int quantity){
        this.item = item;
        this.type = type;
        this.price= price;
        this.quantity = quantity;

    }
    public Inventory(String item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Inventory(String type) {
        this.type = type;
    }

    //    public Inventory(String type){
//        this.type = type;
//        
//    }
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
                " type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
