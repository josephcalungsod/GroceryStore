package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Inventory{
    private String item;
    private  String type;
    private double price;
    private int quantity;
    private int item_id;
    private String farm_name;
    private String brand;
    private String contact;

    Connection conn = ConnectionSingleton.getConnection();

    public Inventory(){

    }
    public Inventory(String item, String type, double price, int quantity,
                     int item_id, String farm_name, String brand, String contact){
        this.item = item;
        this.type=type;
        this.price= price;
        this.quantity = quantity;
        this.item_id=item_id;
        this.farm_name=farm_name;
        this.brand=brand;
        this.contact=contact;
    }
    public Inventory(String item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public Inventory(String item, String type, double price, int quantity){
        this.item = item;
        this.type=type;
        this.quantity = quantity;
        this.price=price;
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
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", item_id='" + item_id + '\'' +
                ", farm_name='" + farm_name + '\'' +
                ", brand='" + brand + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
