package DAO;

import Model.Customer;
import org.h2.command.Prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection conn;

    public CustomerDAO(Connection conn){
        this.conn = conn;
    }


    /**
     * Add customer to customer table via customer list
     * @param customer
     */
    public void addCustomer(Customer customer) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into customer (first_name, last_name, city, zip_code) values (?, ?, ?, ?)");

            ps.setString(1, customer.getCustomerFirstName());
            ps.setString(2, customer.getCustomerLastName());
            ps.setString(3, customer.getCustomerCity());
            ps.setInt(4, customer.getCustomerZip());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a customer from customer table
     * @param customer
     */
    public void deleteCustomer(Customer customer) {
        try{
            PreparedStatement ps = conn.prepareStatement("delete customer where customer_id = ?");
            ps.setInt(1, customer.getCustomerId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Update customer information: (first name, last name, city, zip code) via customer_id
     * @param customer
     */
    public void updateCustomer(Customer customer) {
        try{
            PreparedStatement ps = conn.prepareStatement("update customer set first_name=? last_name=? city=? zip_code=? where customer_id=?");
            ps.setString(1, customer.getCustomerFirstName());
            ps.setString(2, customer.getCustomerLastName());
            ps.setString(3, customer.getCustomerCity());
            ps.setInt(4, customer.getCustomerZip());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Get customer record via customer id
     * @param customerId
     * @return
     */
    public Customer getCustomerById(int customerId) {
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer where customer_id=?");
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCity = rs.getString("city");
                int dbZip = rs.getInt("zip_code");
                return new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCity, dbZip);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get customer record b
     * @param customerFirstName
     * @return
     */
    public List<Customer> getAllCustomersByFirstName(String customerFirstName) {
        List<Customer> customerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer where first_name=?");
            ps.setString(1, customerFirstName);

            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");
                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);


            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public List<Customer> getAllCustomersByLastName(String customerLastName) {
        List<Customer> customerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer where last_name=?");
            ps.setString(1, customerLastName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");
                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");

                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
    public List<Customer> getAllCustomersByCity(String city) {
        List<Customer> customerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer where city=?");
            ps.setString(1, city);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int dbCustomerId = rs.getInt("customer_id");
                String dbCustomerFirstName = rs.getString("first_name");
                String dbCustomerLastName = rs.getString("last_name");
                String dbCustomerCity = rs.getString("city");
                int dbCustomerZip = rs.getInt("zip_code");

                Customer dbCustomerList = new Customer(dbCustomerId, dbCustomerFirstName, dbCustomerLastName, dbCustomerCity, dbCustomerZip);
                customerList.add(dbCustomerList);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
}
