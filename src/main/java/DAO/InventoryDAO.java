package DAO;

import Model.Customer;
import Model.Inventory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This InventoryDAO class is used to act as a layer between the Java code and access to the main
 * SQL database table grocery_store, with a series of methods that have specific interactions with the table.
 */
public class InventoryDAO {

    private Connection conn;

    /**
     * Constructs an InventoryDAO with a database connection.
     *
     * @param conn The database connection.
     */
    public InventoryDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * This method takes in an object inventory of type class Inventory to insert into
     * the SQL database table 'grocery_store', adding a record row of item name, price, and quantity.
     *
     * @param inventory The Inventory object to be added.
     */
    public void addItem(Inventory inventory) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into grocery_store (Item, Type, Price, Quantity) values (?, ?, ?, ?)");
            ps.setString(1, inventory.getItem());
            ps.setString(2, inventory.getType());
            ps.setDouble(3, inventory.getPrice());
            ps.setInt(4, inventory.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to grab records from the table 'grocery_store' with the item name matching
     * the passed parameter String, 'item'. These records are then stored into Java variables and added
     * to the new Inventory object, dbInventory, and returned.
     *
     * @param item The name of the item to retrieve.
     * @return The Inventory object representing the retrieved item, or null if not found.
     */
    public Inventory getItemByName(String item) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM grocery_store " +
                    "left join grocery_info " +
                    "ON grocery_store.item = grocery_info.item " +
                    "WHERE grocery_store.item = ?");
            ps.setString(1, item);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dbItem = rs.getString("item");
                String dbType = rs.getString("type");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                int dbItem_id = rs.getInt("item_id");
                String dbFarm_name = rs.getString("farm_name");
                String dbBrand = rs.getString("brand");
                String dbContact = rs.getString("contact");

                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity, dbItem_id, dbFarm_name, dbBrand, dbContact);
                return dbInventory;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to delete a record from the table 'grocery_store' that matches the passed
     * String, 'item'.
     *
     * @param item The name of the item to delete.
     */
    public void deleteItem(String item) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from grocery_store where Item = ?");
            ps.setString(1, item);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to update the quantity of a record in the table 'grocery_store', matching the item name
     * passed in the object 'inventory'.
     *
     * @param inventory The Inventory object containing the updated quantity.
     */
    public void updateItem(Inventory inventory) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE grocery_store set quantity=? where Item = ?");
            ps.setInt(1, inventory.getQuantity());
            ps.setString(2, inventory.getItem());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to retrieve all records from the table 'grocery_store', store them in an Inventory
     * object 'dbInventory', add each object as an element in an ArrayList, 'inventoryList', and return this
     * ArrayList.
     *
     * @return A List of Inventory objects representing all items in the database.
     */
    public List<Inventory> getAllItems() {
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM grocery_store " +
                    "left join grocery_info " +
                    "ON grocery_store.item = grocery_info.item  ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String dbItem = rs.getString("Item");
                String dbType = rs.getString("Type");
                double dbPrice = rs.getDouble("Price");
                int dbQuantity = rs.getInt("Quantity");
                int dbItem_id = rs.getInt("Item_id");
                String dbFarm_name = rs.getString("Farm_name");
                String dbBrand = rs.getString("Brand");
                String dbContact = rs.getString("Contact");

                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity, dbItem_id, dbFarm_name, dbBrand, dbContact);
                inventoryList.add(dbInventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    /**
     * This method is used to retrieve all items by type.
     *
     * @param type The type of items to retrieve.
     * @return A List of Inventory objects representing items of the specified type.
     */
    public List<Inventory> getAllItemsByType(String type) {
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM grocery_store " +
                    "inner join grocery_info " +
                    "ON grocery_store.item = grocery_info.item where type = ?");
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String dbItem = rs.getString("item");
                String dbType = rs.getString("type");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                String dbFarm_name = rs.getString("Farm_name");
                String dbBrand = rs.getString("Brand");
                String dbContact = rs.getString("Contact");
                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity, dbFarm_name, dbBrand, dbContact);
                inventoryList.add(dbInventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    // Customer TABLE API reroute

    /**
     * Get a list of all customers.
     *
     * @return A List of all Customer objects in the database.
     */
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");

                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    /**
     * Get a list of customers by city.
     *
     * @param city The city to filter by.
     * @return A List of Customer objects in the specified city.
     */
    public List<Customer> getAllCustomersByCity(String city) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer where city=?");
            ps.setString(1, city);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");

                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }




    /**
     * Update customer information by customer ID.
     *
     * @param c The Customer object with updated information.
     */
    public void updateCustomer(Customer c) {
        try {
            PreparedStatement ps = conn.prepareStatement("update customer set first_name=?, last_name=?, city=?, zip_code=? where customer_id=?");
            ps.setString(1, c.getCustomerFirstName());
            ps.setString(2, c.getCustomerLastName());
            ps.setString(3, c.getCustomerCity());
            ps.setInt(4, c.getCustomerZip());
            ps.setInt(5, c.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new customer to the customer table.
     *
     * @param c The Customer object to be added.
     */
    public void addCustomer(Customer c) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into customer (first_name, last_name, city, zip_code) values (?, ?, ?, ?)");
            ps.setString(1, c.getCustomerFirstName());
            ps.setString(2, c.getCustomerLastName());
            ps.setString(3, c.getCustomerCity());
            ps.setInt(4, c.getCustomerZip());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
