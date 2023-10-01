package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;

/**
 * The Inventory class represents information about an inventory item.
 */
public class Inventory {
    private String item;
    private String type;
    private double price;
    private int quantity;
    private int item_id;
    private String farm_name;
    private String brand;
    private String contact;

    // Get a database connection using a Singleton pattern.
    Connection conn = ConnectionSingleton.getConnection();

    /**
     * Default constructor for the Inventory class.
     */
    public Inventory() {}

    /**
     * Constructs an Inventory object with specified attributes.
     *
     * @param item      The name of the inventory item.
     * @param type      The type of the inventory item.
     * @param price     The price of the inventory item.
     * @param quantity  The quantity of the inventory item.
     * @param item_id   The unique identifier for the inventory item.
     * @param farm_name The name of the farm associated with the item.
     * @param brand     The brand of the item.
     * @param contact   The contact information for the item.
     */
    public Inventory(String item, String type, double price, int quantity, int item_id, String farm_name, String brand, String contact) {
        this.item = item;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.item_id = item_id;
        this.farm_name = farm_name;
        this.brand = brand;
        this.contact = contact;
    }
    public Inventory(String item, String type, double price, int quantity, String farm_name, String brand, String contact) {
        this.item = item;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.farm_name = farm_name;
        this.brand = brand;
        this.contact = contact;
    }

    /**
     * Constructs an Inventory object with the item name and quantity.
     *
     * @param item     The name of the inventory item.
     * @param quantity The quantity of the inventory item.
     */
    public Inventory(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Constructs an Inventory object with specified attributes, excluding item_id, farm_name, brand, and contact.
     *
     * @param item     The name of the inventory item.
     * @param type     The type of the inventory item.
     * @param price    The price of the inventory item.
     * @param quantity The quantity of the inventory item.
     */
    public Inventory(String item, String type, double price, int quantity) {
        this.item = item;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get the name of the inventory item.
     *
     * @return The item name.
     */
    public String getItem() {
        return item;
    }

    /**
     * Get the price of the inventory item.
     *
     * @return The item price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the quantity of the inventory item.
     *
     * @return The item quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the name of the inventory item.
     *
     * @param item The item name.
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Set the price of the inventory item.
     *
     * @param price The item price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Set the quantity of the inventory item.
     *
     * @param quantity The item quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the unique identifier for the inventory item.
     *
     * @return The item's unique identifier.
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * Set the unique identifier for the inventory item.
     *
     * @param item_id The item's unique identifier.
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * Get the name of the farm associated with the item.
     *
     * @return The farm name.
     */
    public String getFarm_name() {
        return farm_name;
    }

    /**
     * Set the name of the farm associated with the item.
     *
     * @param farm_name The farm name.
     */
    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    /**
     * Get the brand of the item.
     *
     * @return The item brand.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the brand of the item.
     *
     * @param brand The item brand.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get the contact information for the item.
     *
     * @return The item contact information.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Set the contact information for the item.
     *
     * @param contact The item contact information.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Get the type of the inventory item.
     *
     * @return The item type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the inventory item.
     *
     * @param type The item type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Override of the toString method to provide a string representation of the Inventory object.
     *
     * @return A string representation of the Inventory object.
     */
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
}
