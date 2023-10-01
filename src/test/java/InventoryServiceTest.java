import Model.Inventory;
import Service.InventoryService;
import Util.ConnectionSingleton;
import junit.framework.TestCase;
import DAO.InventoryDAO;
import org.junit.Assert;

import java.sql.Connection;
import java.util.List;

/**
 * The InventoryServiceTest class contains test cases for the InventoryService class.
 */
public class InventoryServiceTest extends TestCase {
    Connection conn = ConnectionSingleton.getConnection();
    Inventory inventory;
    InventoryDAO inventoryDAO = new InventoryDAO(conn);
    InventoryService inventoryService = new InventoryService(inventoryDAO);

    /**
     * Test case to verify the addItem method of the InventoryService class.
     */
    public void testAddItem() {
        inventory = new Inventory("fish", "sea_food", 12.2, 120);
        inventoryService.addItem(inventory);
        String actual = inventory.getItem();
        String expected = "fish";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test case to verify the getItemByName method of the InventoryService class.
     */
    public void testGetItemByName() {
        String actual = inventoryService.getItemByName("apple").getItem();
        String expected = "apple";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test case to verify the deleteItem method of the InventoryService class.
     */
    public void testDeleteItem() {
        inventoryService.deleteItem("banana");
        Inventory actual = inventoryService.getItemByName("banana");
        Inventory expected = null;
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test case to verify the updateItem method of the InventoryService class.
     */
    public void testUpdateItem() {
        inventory = new Inventory("apple", 293);
        inventoryService.updateItem(inventory);
        int actual = inventory.getQuantity();
        int expected = 293;
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test case to verify the getAllItems method of the InventoryService class.
     */
    public void testGetAllItems() {
        List<Inventory> inventoryList = inventoryService.getAllItems();
        String actual = inventoryList.get(0).getItem();
        String expected = "apple";
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test case to verify the getAllItemsByType method of the InventoryService class.
     */
    public void testGetAllItemsByType() {
        List<Inventory> inventoryList = inventoryService.getAllItemsByType("produce");
        String actual = inventoryList.get(0).getItem();
        String expected = "apple";
        Assert.assertEquals(expected, actual);
    }
}
