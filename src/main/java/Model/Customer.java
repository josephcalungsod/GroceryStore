package Model;

import java.util.List;

public class Customer {
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private String customerCity;
    private int customerZip;

    public Customer() {}
    public Customer (int customerId, String customerFirstName, String customerLastName, String customerCity, int customerZip){
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.customerZip = customerZip;

    }

    /**
     * overloaded method for adding to table w/ auto_increment?
     * @param customerFirstName
     * @param customerLastName     *
     * @param customerCity
     * @param customerZip
     */
    public Customer (String customerFirstName, String customerLastName, String customerCity, int customerZip){

        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCity = customerCity;
        this.customerZip = customerZip;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerFirstName(String customerFirstName) { this.customerFirstName = customerFirstName; }
    public String getCustomerFirstName() { return customerFirstName; }
    public void setCustomerLastName(String customerLastName) { this.customerLastName = customerLastName; }
    public String getCustomerLastName() { return customerLastName; }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public int getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(int customerZip) {
        this.customerZip = customerZip;
    }

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
