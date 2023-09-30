package Service;

import DAO.CustomerDAO;
import DAO.InventoryDAO;
import Exceptions.NoProductFoundException;
import Model.Customer;
import Model.Inventory;
import Util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The InventoryService class provides methods for interacting with inventory and customer data.
 */
public class InventoryService {
    private InventoryDAO inventoryDAO;
    private CustomerDAO customerDAO;

    /**
     * Constructs an InventoryService object with a specified InventoryDAO.
     *
     * @param inventoryDAO The DAO used for inventory-related database interactions.
     */
    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    /**
     * Adds an inventory item to the database.
     *
     * @param inventory The inventory item to be added.
     */
    public void addItem(Inventory inventory) {
        inventoryDAO.addItem(inventory);
    }

    /**
     * Retrieves an inventory item by its name from the database.
     *
     * @param item The name of the inventory item to retrieve.
     * @return The inventory item with the specified name, or null if not found.
     */
    public Inventory getItemByName(String item) {
        return inventoryDAO.getItemByName(item);
    }

    /**
     * Deletes an inventory item from the database.
     *
     * @param item The name of the inventory item to be deleted.
     */
    public void deleteItem(String item) {
        inventoryDAO.deleteItem(item);
    }

    /**
     * Updates an inventory item in the database.
     *
     * @param inventory The updated inventory item.
     */
    public void updateItem(Inventory inventory) {
        inventoryDAO.updateItem(inventory);
    }

    /**
     * Retrieves a list of all inventory items from the database.
     *
     * @return A list of all inventory items in the database.
     */
    public List<Inventory> getAllItems() {
        return inventoryDAO.getAllItems();
    }

    /**
     * Retrieves a list of inventory items of a specific type from the database.
     *
     * @param type The type of inventory items to retrieve.
     * @return A list of inventory items with the specified type.
     */
    public List<Inventory> getAllItemsByType(String type) {
        return inventoryDAO.getAllItemsByType(type);
    }

    /**
     * Retrieves a list of all customers from the database.
     *
     * @return A list of all customers in the database.
     */
    public List<Customer> getAllCustomers() {
        return inventoryDAO.getAllCustomers();
    }

    /**
     * Updates customer information in the database.
     *
     * @param customer The updated customer information.
     */
    public void updateCustomer(Customer customer) {
        inventoryDAO.updateCustomer(customer);
    }

    /**
     * Adds a customer to the database.
     *
     * @param customer The customer to be added.
     */
    public void addCustomer(Customer customer) {
        inventoryDAO.addCustomer(customer);
    }

    /**
     * Retrieves a list of customers in a specific city from the database.
     *
     * @param city The city to search for.
     * @return A list of customers in the specified city.
     */
    public List<Customer> getAllCustomersByCity(String city) {
        return inventoryDAO.getAllCustomersByCity(city);
    }
}
