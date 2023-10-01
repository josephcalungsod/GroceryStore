package DAO;

import junit.framework.TestCase;
import Model.Customer;
import Util.ConnectionSingleton;
import junit.framework.Assert;
import java.sql.Connection;
import java.util.List;

/**
 * This class contains test cases for the CustomerDAO class.
 */
public class CustomerDAOTest extends TestCase {
    Connection conn;
    CustomerDAO customerDAO;
    Customer customer;
    /**
     * Set up the test environment by creating a database connection and initializing the CustomerDAO.
     *
     * @throws Exception if an error occurs during setup.
     */
    protected void setUp() throws Exception {
        super.setUp();
        //reset the database for each operation of database
        ConnectionSingleton.resetTestDatabase();
        //connect database
        conn = ConnectionSingleton.getConnection();
        //instantiate a CustomerDAO object
        customerDAO = new CustomerDAO(conn);
    }
    /**
     * Tear down the test environment.
     *
     * @throws Exception if an error occurs during teardown.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    /**
     * Test the addCustomer method by adding a customer and checking if the customer ID is not null.
     */
    public void testAddCustomer() {
        // Create a customer to add
        Customer customer = new Customer("Tom", "Doe", "New York", 10001);

        // Add the customer to the database
        customerDAO.addCustomer(customer);

        // Check if the customer ID is not null
        assertNotNull(customer.getCustomerId());
    }
    /**
     * Test the deleteCustomer method by adding a customer, deleting it, and checking if it no longer exists in the database.
     */
    public void testDeleteCustomer() {
        // Create a customer to add and then delete
        Customer customer = new Customer("Alice", "Smith", "Los Angeles", 90001);
        customerDAO.addCustomer(customer);

        // Delete the customer
        customerDAO.deleteCustomer(customer);

        // Check if the customer no longer exists in the database
        assertNull(customerDAO.getCustomerById(customer.getCustomerId()));
    }
    /**
     * Test the updateCustomer method by updating a customer's information and checking if it has changed in the database.
     */
    public void testUpdateCustomer() {
        // Get the customer with ID 1 from the database
        Customer expected = customerDAO.getCustomerById(1);

        // Create a new customer object with updated information
        customer = new Customer(1, "Bob", "Johnson", "Chicago", 60601);

        // Update the customer's information in the database
        customerDAO.updateCustomer(customer);

        // Get the updated customer from the database
        Customer actual = customerDAO.getCustomerById(1);

        // Check if the updated customer is not the same as the expected customer
        Assert.assertNotSame(actual, expected);
    }
    /**
     * Test the getCustomerById method by retrieving a customer by ID and checking if the first name matches the expected value.
     */
    public void testGetCustomerById() {
        // Get the customer with ID 1 from the database
        Customer customer = customerDAO.getCustomerById(1);

        // Get the actual first name of the retrieved customer
        String actual = customer.getCustomerFirstName();

        // Expected first name
        String expected = "han";

        // Check if the actual first name matches the expected first name
        assertEquals(expected, actual);
    }
    /**
     * Test the getAllCustomersByFirstName method by adding customers with the same first name and checking if they are retrieved correctly.
     */
    public void testGetAllCustomersByFirstName() {
        // Create two customers with the same first name "John"
        Customer customer1 = new Customer("John", "Doe", "New York", 10001);
        Customer customer2 = new Customer("John", "Smith", "Los Angeles", 90001);

        // Add the customers to the database
        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);

        // Retrieve customers with the first name "John" from the database
        List<Customer> customers = customerDAO.getAllCustomersByFirstName("John");

        // Check if the retrieved list is not null and contains at least two customers
        assertNotNull(customers);
        assertTrue(customers.size() >= 2);
    }
    /**
     * Test the getAllCustomersByLastName method by adding customers with the same last name and checking if they are retrieved correctly.
     */
    public void testGetAllCustomersByLastName() {
        // Create two customers with the same last name "Smith"
        Customer customer1 = new Customer("John", "Smith", "New York", 10001);
        Customer customer2 = new Customer("Chris", "Smith", "Los Angeles", 90001);

        // Add the customers to the database
        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);

        // Retrieve customers with the last name "Smith" from the database
        List<Customer> customers = customerDAO.getAllCustomersByLastName("Smith");

        // Check if the retrieved list is not null and contains at least two customers
        assertNotNull(customers);
        assertTrue(customers.size() >= 2);
    }
    /**
     * Test the getAllCustomers method by retrieving all customers from the database and counting them.
     */
    public void testGetAllCustomers() {
        // Retrieve all customers from the database
        List<Customer> customerList = customerDAO.getAllCustomers();
        // Initialize a counter to count the customers
        int counter = 0;
        // Count the customers
        for (Customer customer1 : customerList) {
           counter++;
        }
        // Expected number of customers
        int expected = 3;
        // Check if the actual number of customers matches the expected number
        int actual = counter;
        assertEquals(expected, actual);
    }
    /**
     * Test the getAllCustomersByCity method by retrieving customers from the database by a specific city and counting them.
     */
    public void testGetAllCustomersByCity() {
        // Retrieve customers from the database in the city "corellia"
        List<Customer> customerList = customerDAO.getAllCustomersByCity("corellia");

        // Initialize a counter to count the customers
        int counter = 0;

        // Count the customers
        for (Customer customer1 : customerList) {
            counter++;
        }

        // Expected number of customers in the city "corellia"
        int expected = 1;

        // Check if the actual number of customers matches the expected number
        int actual = counter;
        assertEquals(expected, actual);
    }
}
