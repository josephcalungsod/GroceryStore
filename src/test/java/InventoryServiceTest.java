import Model.Customer;
import Model.Inventory;
import Service.InventoryService;
import Util.ConnectionSingleton;
import junit.framework.TestCase;
import DAO.InventoryDAO;
import org.junit.Assert;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The InventoryServiceTest class contains test cases for the InventoryService class.
 */
public class InventoryServiceTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        //reset the database for each operation of database
        ConnectionSingleton.resetTestDatabase();

    }
    Connection conn = ConnectionSingleton.getConnection();
    InventoryDAO inventoryDAO = new InventoryDAO(conn);
    InventoryService inventoryService = new InventoryService(inventoryDAO);
    Inventory inventory;
    Customer customer;
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
        //since there is a foreign key associated with this table, wecan only delete
        //a item not existed in another table.
        inventoryService.deleteItem("fish");
        Inventory actual = inventoryService.getItemByName("fish");
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
    public void testGetAllCustomers(){
        List<Customer> customerList = inventoryService.getAllCustomers();
        int i=0;
        for(Customer customer:customerList){
            i++;
        }
        int expected=3;
        int actual=i;
        assertEquals(actual, expected);

    }
    public void testUpdateCustomer(){

        customer = new Customer(1,"aaa", "bbb", "atlanta", 12321);
        inventoryService.updateCustomer(customer);
        String city = "corellia";
        List<Customer> actual = inventoryService.getAllCustomersByCity(city);
        Customer expected = customer;
        assertNotEquals(actual, expected);

    }
//    public void testAddCustomer(){
//
//    }
//    public void testGetAllCustomersByCity(){
//
//    }
}
