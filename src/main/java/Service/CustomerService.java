package Service;

import DAO.CustomerDAO;
import Model.Customer;
import Util.LogUtil;

import java.util.List;

/**
 * The CustomerService class provides methods for interacting with customer data.
 */
public class CustomerService {
    private CustomerDAO customerDAO;

    /**
     * Constructs a CustomerService object with a specified CustomerDAO.
     *
     * @param customerDAO The DAO used for database interactions.
     */
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        LogUtil.log.info("setting up customer service");
    }

    /**
     * Adds a customer to the database.
     *
     * @param customer The customer to be added.
     */
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
        LogUtil.log.info("adding customer");
    }

    /**
     * Deletes a customer from the database.
     *
     * @param customer The customer to be deleted.
     */
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
        LogUtil.log.info("deleting customer");
    }

    /**
     * Updates customer information in the database.
     *
     * @param customer The updated customer information.
     */
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
        LogUtil.log.info("updating customer");
    }

    /**
     * Retrieves a customer by their unique ID from the database.
     *
     * @param customerId The unique ID of the customer to retrieve.
     * @return The customer with the specified ID, or null if not found.
     */
    public Customer getCustomerById(int customerId) {
        LogUtil.log.info("getting customer by ID");
        return customerDAO.getCustomerById(customerId);
    }

    /**
     * Retrieves a list of customers by their first name from the database.
     *
     * @param customerFirstName The first name to search for.
     * @return A list of customers with the specified first name.
     */
    public List<Customer> getAllCustomersByFirstName(String customerFirstName) {
        LogUtil.log.info("getting all customers by first name");
        return customerDAO.getAllCustomersByFirstName(customerFirstName);
    }

    /**
     * Retrieves a list of customers by their last name from the database.
     *
     * @param customerLastName The last name to search for.
     * @return A list of customers with the specified last name.
     */
    public List<Customer> getAllCustomersByLastName(String customerLastName) {
        LogUtil.log.info("getting all customers by last name");
        return customerDAO.getAllCustomersByLastName(customerLastName);
    }

    /**
     * Retrieves a list of customers by their city from the database.
     *
     * @param city The city to search for.
     * @return A list of customers in the specified city.
     */
    public List<Customer> getAllCustomersByCity(String city) {
        LogUtil.log.info("getting all customers by city");
        return customerDAO.getAllCustomersByCity(city);
    }

    /**
     * Retrieves a list of all customers from the database.
     *
     * @return A list of all customers in the database.
     */
    public List<Customer> getAllCustomers() {
        LogUtil.log.info("getting all customers");
        return customerDAO.getAllCustomers();
    }
}
