package DAO;

import Model.Inventory;
import Util.ConnectionSingleton;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Connection;
import java.util.List;

public class InventoryDAOTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }
    Connection conn = ConnectionSingleton.getConnection();
    InventoryDAO inventoryDAO=new InventoryDAO(conn);
    Inventory inventory;

    public void testAddItem() {
        inventory=new Inventory("strawberry", "fruit", 11.1, 100);
        String item=inventory.getItem();
        inventoryDAO.addItem(inventory);
        double actual=inventoryDAO.getItemByName(item).getPrice();
        double expected=11.1;
        Assert.assertEquals(actual,expected);
    }
    public void testGetItemByName() {
        String item="fruit";
        double actual=inventoryDAO.getItemByName(item).getPrice();
        double expected=11.1;
        Assert.assertEquals(actual,expected);
    }
    public void testUpdateItem() {
        inventory=new Inventory("fruit", 200);
        inventoryDAO.updateItem(inventory);
        String item=inventory.getItem();
        double actual=inventoryDAO.getItemByName(item).getQuantity();
        double expected=200;
        Assert.assertEquals(actual,expected);
    }

    public void testDeleteItem() {
        String item="fruit";
        inventoryDAO.deleteItem(item);
        Inventory actual=inventoryDAO.getItemByName(item);
        Inventory expected=null;
        Assert.assertEquals(actual,expected);
    }
    public void testGetAllItems() {
        List<Inventory> inventoryList = inventoryDAO.getAllItems();
        Assert.assertNotNull(inventoryList);
        Assert.assertFalse(inventoryList.isEmpty());

    }

}