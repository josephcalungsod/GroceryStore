package Model;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerCity;
    private int customerZip;

    public Customer() {}
    public Customer (int customerId, String customerName, String customerAddress, String customerCity, int customerZip){
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerZip = customerZip;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

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
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerZip=" + customerZip +
                '}';
    }
}
