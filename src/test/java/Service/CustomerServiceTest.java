package Service;

import DAO.CustomerDAO;
import Model.Customer;
import Util.ConnectionSingleton;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The CustomerServiceTest class contains JUnit tests for the CustomerService class.
 */
public class CustomerServiceTest {
    Connection conn = ConnectionSingleton.getConnection();
    CustomerDAO customerDAO;
    CustomerService customerService;

    Customer customer;

    /**
     * Sets up the test environment before running each test method.
     */
    @Before
    public void setUp() {
        // Initialize customerDAO with a test database connection
        customerDAO = new CustomerDAO(conn); // Replace with your actual implementation

        // Initialize the customerService with the customerDAO
        customerService = new CustomerService(customerDAO);
    }

    /**
     * Tests the addCustomer method of CustomerService.
     */
    @Test
    public void testAddCustomer() {
        // Create a customer object to add
        Customer customerToAdd = new Customer("aa", "bb", "cc", 12345);

        // Perform the add operation
        customerService.addCustomer(customerToAdd);
        String actual="aabbcc";
        String expected=customerToAdd.getCustomerFirstName()+
                customerToAdd.getCustomerLastName()+
                customerToAdd.getCustomerCity();
        assertEquals(actual, expected);
    }

    /**
     * Tests the deleteCustomer method of CustomerService.
     */
    @Test
    public void deleteCustomer() {
        customer=customerService.getCustomerById(1);
        customerService.deleteCustomer(customer);
        Customer actual=customerService.getCustomerById(1);
        Customer expected=null;
        assertEquals(actual, expected);
    }

    /**
     * Tests the updateCustomer method of CustomerService.
     */
    @Test
    public void updateCustomer() {
        Customer expected=customerService.getCustomerById(1);
        customer=new Customer(1,"aaa", "bbb", "atlanta", 12321);
        customerService.updateCustomer(customer);
        Customer actual=customerService.getCustomerById(1);
        assertNotEquals(actual, expected);
    }

    /**
     * Tests the getCustomerById method of CustomerService.
     */
    @Test
    public void getCustomerById() {
        Customer customer=customerService.getCustomerById(1);
        String actual=customer.getCustomerFirstName();
        String expected="han";
        assertEquals(actual, expected);
    }

    /**
     * Tests the getAllCustomersByFirstName method of CustomerService.
     */
    @Test
    public void getAllCustomersByFirstName() {
        List<Customer> customerList=customerService.getAllCustomersByFirstName("han");
        String actual=customerList.get(0).getCustomerLastName();
        String expected="solo";
        assertEquals(actual, expected);
    }

    /**
     * Tests the getAllCustomersByLastName method of CustomerService.
     */
    @Test
    public void getAllCustomersByLastName() {
        List<Customer> customerList=customerService.getAllCustomersByLastName("solo");
        String actual=customerList.get(0).getCustomerFirstName();
        String expected="han";
        assertEquals(actual, expected);

    }

    /**
     * Tests the getAllCustomersByCity method of CustomerService.
     */
    @Test
    public void getAllCustomersByCity() {
        List<Customer> customerList=customerService.getAllCustomersByCity("corellia");
        String actual=customerList.get(0).getCustomerFirstName();
        String expected="han";
        assertEquals(actual, expected);
    }

    /**
     * Tests the getAllCustomers method of CustomerService.
     */
    @Test
    public void getAllCustomers() {
        List<Customer> customerList=customerService.getAllCustomers();
        int counter=0;
        for(Customer customer:customerList){
            counter++;
        }
        int expected=3;
        int actual=counter;
        assertEquals(actual, expected);
    }
}
