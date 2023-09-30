package Model;

import java.util.List;

/**
 * The Customer class represents customer information.
 */
public class Customer {
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerCity;
    private int customerZip;

    /**
     * Default constructor for the Customer class.
     */
    public Customer() {}

    /**
     * Constructs a Customer object with specified attributes.
     *
     * @param customerId       The unique identifier for the customer.
     * @param customerFirstName The first name of the customer.
     * @param customerLastName  The last name of the customer.
     * @param customerCity      The city where the customer lives.
     * @param customerZip       The ZIP code of the customer's address.
     */
    public Customer(int customerId, String customerFirstName, String customerLastName, String customerCity, int customerZip) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.customerZip = customerZip;
    }

    /**
     * Constructs a Customer object with specified attributes, excluding customerId.
     * This constructor is typically used when adding a new customer to a table with auto-incremented IDs.
     *
     * @param customerFirstName The first name of the customer.
     * @param customerLastName  The last name of the customer.
     * @param customerCity      The city where the customer lives.
     * @param customerZip       The ZIP code of the customer's address.
     */
    public Customer(String customerFirstName, String customerLastName, String customerCity, int customerZip) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.customerZip = customerZip;
    }

    /**
     * Get the customer's unique identifier (ID).
     *
     * @return The customer's ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer's unique identifier (ID).
     *
     * @param customerId The customer's ID.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the customer's first name.
     *
     * @return The customer's first name.
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * Set the customer's first name.
     *
     * @param customerFirstName The customer's first name.
     */
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * Get the customer's last name.
     *
     * @return The customer's last name.
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * Set the customer's last name.
     *
     * @param customerLastName The customer's last name.
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * Get the city where the customer lives.
     *
     * @return The customer's city.
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Set the city where the customer lives.
     *
     * @param customerCity The customer's city.
     */
    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    /**
     * Get the ZIP code of the customer's address.
     *
     * @return The customer's ZIP code.
     */
    public int getCustomerZip() {
        return customerZip;
    }

    /**
     * Set the ZIP code of the customer's address.
     *
     * @param customerZip The customer's ZIP code.
     */
    public void setCustomerZip(int customerZip) {
        this.customerZip = customerZip;
    }

    /**
     * Override of the toString method to provide a string representation of the Customer object.
     *
     * @return A string representation of the Customer object.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerZip=" + customerZip +
                '}';
    }
}
