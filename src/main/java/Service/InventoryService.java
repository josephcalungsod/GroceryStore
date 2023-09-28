package Service;

import DAO.InventoryDAO;
import Exceptions.NoProductFoundException;
import Model.Inventory;
import Util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO;


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

}