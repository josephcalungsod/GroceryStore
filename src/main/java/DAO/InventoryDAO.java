package DAO;

import Model.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This InventoryDAO class is used to act as a layer between the Java code and access to the main
 * SQL database table grocery_store, with a series of methods that have specific interactions with the table.
 */
public class InventoryDAO {

    private Connection conn;

    public InventoryDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * This method takes in an object inventory of type class Inventory to insert into
     * the SQL database table 'grocery_store', adding a record row of item name, price, and quantity.
     * @param inventory
     */
    public void addItem(Inventory inventory) {
        try {
        PreparedStatement ps = conn.prepareStatement("insert into grocery_store (Item, Price, Quantity) values (?, ?, ?)");
        ps.setString(1, inventory.getItem());
        ps.setDouble(2, inventory.getPrice());
        ps.setInt(3, inventory.getQuantity());
        ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used grab records from the table 'grocery_store' with the item name matching
     * the passed parameter String, 'item'. These records are then stored into Java variables and added
     * to the new Inventory object, dbInventory and returned.
     * @param item
     * @return
     */
    public Inventory getItemByName(String item) {
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_store where item = ?");
            ps.setString(1, item);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String dbItem = rs.getString("item");
                String dbType = rs.getString("type");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity);
                return dbInventory;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to delete a record from the table 'grocery_store' that matches the passed
     * String, 'item'.
     * @param item
     */
    public void deleteItem(String item) {
        try{
            PreparedStatement ps = conn.prepareStatement("delete grocery_store where Item = ?");
            ps.setString(1, item);
            ps.executeUpdate();
        }catch(SQLException e){
         e.printStackTrace();
        }
    }

    /**
     * This method is used to update the quantity of a record in the table 'grocery_store', matching the item name
     * passed in the object 'inventory'
     *
     * @param inventory
     */
    public void updateItem(Inventory inventory){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE grocery_store set quantity=? where Item = ?");
            ps.setInt(1, inventory.getQuantity());
            ps.setString(2, inventory.getItem());
            ps.executeUpdate();
        }catch(SQLException e)
        {e.printStackTrace();
        }


    }

    /**
     * This method is used to retrieve all records from the table 'grocery_store', store them in an Inventory
     * object 'dbInventory', add each object as an element in an ArrayList, 'inventoryList', and return this
     * ArrayList.
     * @return
     */
    public List<Inventory> getAllItems() {
        List<Inventory> inventoryList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_store");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String dbItem = rs.getString("Item");
                String dbType = rs.getString("Type");
                double dbPrice = rs.getDouble("Price");
                int dbQuantity = rs.getInt("Quantity");
                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity);
                inventoryList.add(dbInventory);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return inventoryList;
    }

    /**
     * This method is used to retrieve all items by type
     * @return
     */
    public List<Inventory> getAllItemsByType(String type) {
        List<Inventory> inventoryList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_store where type = ?");
            ps.setString(1, type);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String dbItem = rs.getString("item");
                String dbType = rs.getString("type");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                Inventory dbInventory = new Inventory(dbItem, dbType, dbPrice, dbQuantity);
                inventoryList.add(dbInventory);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return inventoryList;
    }
}
