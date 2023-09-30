package Service;

import DAO.CustomerDAO;
import DAO.InventoryDAO;
import Exceptions.NoProductFoundException;
import Model.Customer;
import Model.Inventory;
import Util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO;
    private CustomerDAO customerDAO;


    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }


    /**
     * add inventory via InventoryDAO
     * @param inventory
     */
    public void addItem(Inventory inventory) {
        inventoryDAO.addItem(inventory);
    }

    /**
     * get and return inventory item via InventoryDAO
     * @param item
     * @return
     */
    public Inventory getItemByName(String item) {
        Inventory inventory = inventoryDAO.getItemByName(item);
        return inventory;
    }

    /**
     * delete inventory item via InventoryDAO
     * @param item
     */
    public void deleteItem(String item) { inventoryDAO.deleteItem(item); }

    /**
     * update inventory item via InventoryDAO
     * @param inventory
     */
    public void updateItem(Inventory inventory){ inventoryDAO.updateItem(inventory); }

    /**
     * return all items via InventoryDAO
     * @return
     */
    public List<Inventory> getAllItems() {
        List<Inventory> allItems = inventoryDAO.getAllItems();
        return allItems;
    }
    public List<Inventory> getAllItemsByType(String type) {
        List<Inventory> allItemsByType = inventoryDAO.getAllItemsByType(type);
        return allItemsByType;
    }

    //          CUSTOMER TABLE API reroute
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = inventoryDAO.getAllCustomers();
        return allCustomers;
    }

    public void updateCustomer(Customer c) {
        inventoryDAO.updateCustomer(c);
    }

    public void addCustomer(Customer c) {
        inventoryDAO.addCustomer(c);
    }

    public List<Customer> getAllCustomersByCity(String city) {
        List<Customer> allCustomerByCity = inventoryDAO.getAllCustomersByCity(city);
    return allCustomerByCity;
    }
}