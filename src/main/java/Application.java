import Controller.Controller;
import DAO.CustomerDAO;
import DAO.InventoryDAO;
import Model.Customer;
import Model.Inventory;
import Service.CustomerService;
import Service.InventoryService;
import Util.ConnectionSingleton;
import  Model.Order;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
/**
 * The Application class is the entry point for the grocery store management application.
 */
public class Application {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionSingleton.getConnection();
        InventoryDAO inventoryDAO = new InventoryDAO(conn);
        InventoryService inventoryService = new InventoryService(inventoryDAO);
        Controller controller = new Controller(inventoryService);

        // Customer flow; controller layer what do?
        CustomerDAO customerDAO = new CustomerDAO(conn);
        CustomerService customerService = new CustomerService(customerDAO);

        controller.getAPI().start();

        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n[grocery_store] inventory: \n" +
                    "\n(1) Add new item " +
                    "\n(2) Query item " +
                    "\n(3) Delete item " +
                    "\n(4) Update quantity of item " +
                    "\n(5) View Inventory" +
                    "\n(6) View Inventory by Type" +
                    "\n(7) Add Customer" +
                    "\n(8) View Customers" +
                    "\n(9) Get Customer by ID" +
                    "\n(10) Get all customers by first name" +
                    "\n(11) Get all customers by last name" +
                    "\n(12) Get all customers by city"+
                    "\n(13) Get orders by customer id");

            int response = scan.nextInt();

            // INVENTORY table UI
            if (response == 1) {
                // Add item to service class
                System.out.println("(1) ADD: Enter item: ");
                String item = scan.next();
                System.out.println("(1) ADD: Enter type: ");
                String type = scan.next();
                System.out.println("(1) ADD: Enter price: ");
                double price = scan.nextDouble();
                System.out.println("(1) ADD: Enter quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item, type, price, quantity);

                System.out.println("\n");
                inventoryService.addItem(inventory);
            } else if (response == 2) {
                // Query item from service class
                System.out.println("(2) QUERY: Enter name of item:");
                String item = scan.next();
                Inventory inventory = inventoryService.getItemByName(item);

                System.out.println("\n");
                System.out.println(inventory);
            } else if (response == 3) {
                // Delete item using service class
                System.out.println("(3) DELETE: Enter item: ");
                String item = scan.next();

                System.out.println("\n");
                inventoryService.deleteItem(item);
            } else if (response == 4) {
                // Update item using service class
                System.out.println("(4) UPDATE: Enter item: ");
                String item = scan.next();
                System.out.println("(4) UPDATE: Enter price: ");
                double price = scan.nextDouble();
                System.out.println("(4) UPDATE: Enter quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item, quantity);

                System.out.println("\n");
                inventoryService.updateItem(inventory);
            } else if (response == 5) {
                // Query all items from service class
                System.out.println("(5) QUERY: All items:\n");
                inventoryService.getAllItems();
                List<Inventory> inventoryList = inventoryService.getAllItems();

                System.out.println("\n");
                System.out.println(inventoryList);
            } else if (response == 6) {
                // Query type from service class
                System.out.println("(6) QUERY: Enter type: \n" +
                        "( produce / meat / baby_products / international / candy / animal_products / hygiene / paper_products )\n");
                String type = scan.next();
                 List<Inventory> inventory = inventoryService.getAllItemsByType(type);
                 System.out.println(inventory);

                System.out.println("\n");

            }

            // CUSTOMER UI
            else if (response == 7) {
                // Add customer to service class
                System.out.println("(7) ADD CUSTOMER: Enter first name: ");
                String first_name = scan.next();
                System.out.println("(7) ADD CUSTOMER: Enter last name: ");
                String last_name = scan.next();
                System.out.println("(7) ADD CUSTOMER: Enter city: ");
                String city = scan.next();
                System.out.println("(7) ADD CUSTOMER: Enter zip code: ");
                int zip = scan.nextInt();

                Customer customer = new Customer(first_name, last_name, city, zip);

                System.out.println("\n");
                customerService.addCustomer(customer);
            } else if (response == 8) {
                // Query all customers
                System.out.println("(8) QUERY: All customers:\n");
                customerService.getAllCustomers();
                List<Customer> customerList = customerService.getAllCustomers();

                System.out.println("\n");
                System.out.println(customerList);
            } else if (response == 9) {
                // Get customer by *ID*
                System.out.println("(9) QUERY: Enter customer id: \n");
                int customerId = scan.nextInt();
                Customer customer = customerService.getCustomerById(customerId);
                System.out.println(customer);
            } else if (response == 10) {
                // Get customer by *FIRST NAME*
                System.out.println("(10) QUERY: Enter customer first name: \n");
                String customerFirstName = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByFirstName(customerFirstName);
                System.out.println(customerList);
            } else if (response == 11) {
                // Get customer by *LAST NAME*
                System.out.println("(11) QUERY: Enter customer last name: \n");
                String customerLastName = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByLastName(customerLastName);
                System.out.println(customerList);
            } else if (response == 12) {
                // Query all customers from a *CITY*
                System.out.println("(12) QUERY: Enter city: \n");
                String city = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByCity(city);

                System.out.println("\n");
                System.out.println(customerList);
            }else if (response == 13){
                System.out.println("(13) QUERY: Enter your customer id: ");
                int customerId = scan.nextInt();

                ArrayList<String> orderContent = new ArrayList<>();

                System.out.println("Enter your order: ");

                while (true) {
                    System.out.print("Enter an item: ");
                    String item = scan.next();
                    orderContent.add(item);

                    System.out.print("Enter more (y/n): ");
                    String more = scan.next();
                    if (more.equalsIgnoreCase("n")) {
                        break;
                    }
                }
                // Get the current date
                Date orderDate = new Date();
                // Instantiate the Order class with the collected information
                Order order = new Order(orderDate, orderContent, customerId);
                System.out.println("Customer ID is: "+customerId+
                                "\n your order id is: "+1+order.getOrderId()+
                                "\n your order date is: "+order.getOrderDate()+
                                "\n your order is: "+order.getOrderContent());
                Customer customer=customerService.getCustomerById(customerId);
                System.out.println("customer first name is: "+customer.getCustomerFirstName()+
                        "\n customer last name is: "+customer.getCustomerLastName() );

                        // Close the scanner when done
                //scan.close();
            } else {
                // Invalid choice
                System.out.println("\n");
                System.out.println("Invalid choice: '" + response + "'\n");
            }
        }
    }
}
