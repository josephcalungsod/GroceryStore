package Service;

import DAO.CustomerDAO;
import Model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO){ this.customerDAO = customerDAO; }

//    add customer
    public void addCustomer(Customer customer){ customerDAO.addCustomer(customer); }

//    delete customer
    public void deleteCustomer(Customer customer){ customerDAO.deleteCustomer(customer); }

//    update customer
    public void updateCustomer(Customer customer){ customerDAO.updateCustomer(customer); }

//    get customer by id
    public Customer getCustomerById(int customerId){
        Customer customerById = customerDAO.getCustomerById(customerId);
        return customerById;
    }

//    get customers by firstName
    public List<Customer> getAllCustomersByFirstName(String customerFirstName){
        List<Customer> customersByFirstName = customerDAO.getAllCustomersByFirstName(customerFirstName);
        return customersByFirstName;
    }

//    get customers by lastName
    public List<Customer> getAllCustomersByLastName(String customerLastName){
        List<Customer> customersByLastName = customerDAO.getAllCustomersByLastName(customerLastName);
        return customersByLastName;
    }
//    get customers by city
    public List<Customer> getAllCustomersByCity(String city){
        List<Customer> allCustomersByCity = customerDAO.getAllCustomersByCity(city);
        return allCustomersByCity;
    }

//    get all customers
    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = customerDAO.getAllCustomers();
        return allCustomers;
    }


}

