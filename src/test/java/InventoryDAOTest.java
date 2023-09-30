import DAO.InventoryDAO;
import Model.Inventory;
import Util.ConnectionSingleton;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Connection;
import java.util.List;

/**
 * The InventoryDAOTest class contains test cases for the InventoryDAO class.
 */
public class InventoryDAOTest extends TestCase {

    /**
     * This method sets up the test environment before each test case is executed.
     *
     * @throws Exception if there is an exception during setup.
     */
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * This method cleans up the test environment after each test case is executed.
     *
     * @throws Exception if there is an exception during teardown.
     */
    public void tearDown() throws Exception {
        // Clean up resources here, if necessary.
    }

    // Connection and DAO instances used in test cases
    Connection conn = ConnectionSingleton.getConnection();
    InventoryDAO inventoryDAO = new InventoryDAO(conn);
    Inventory inventory;

    /**
     * Test case to verify the addItem method of the InventoryDAO class.
     */
    public void testAddItem() {
        inventory = new Inventory("strawberry", "fruit", 11.1, 100);
        String item = inventory.getItem();
        inventoryDAO.addItem(inventory);
        double actual = inventoryDAO.getItemByName(item).getPrice();
        double expected = 11.1;
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test case to verify the getItemByName method of the InventoryDAO class.
     */
    public void testGetItemByName() {
        String item = "fruit";
        double actual = inventoryDAO.getItemByName(item).getPrice();
        double expected = 11.1;
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test case to verify the updateItem method of the InventoryDAO class.
     */
    public void testUpdateItem() {
        inventory = new Inventory("fruit", 200);
        inventoryDAO.updateItem(inventory);
        String item = inventory.getItem();
        double actual = inventoryDAO.getItemByName(item).getQuantity();
        double expected = 200;
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test case to verify the deleteItem method of the InventoryDAO class.
     */
    public void testDeleteItem() {
        String item = "fruit";
        inventoryDAO.deleteItem(item);
        Inventory actual = inventoryDAO.getItemByName(item);
        Inventory expected = null;
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test case to verify the getAllItems method of the InventoryDAO class.
     */
    public void testGetAllItems() {
        List<Inventory> inventoryList = inventoryDAO.getAllItems();
        Assert.assertNotNull(inventoryList);
        Assert.assertFalse(inventoryList.isEmpty());
    }
}
