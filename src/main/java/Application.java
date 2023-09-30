import Controller.Controller;
import DAO.CustomerDAO;
import DAO.InventoryDAO;
import Model.Customer;
import Model.Inventory;
import Service.CustomerService;
import Service.InventoryService;
import Util.ConnectionSingleton;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionSingleton.getConnection();
        InventoryDAO inventoryDAO = new InventoryDAO(conn);
        InventoryService inventoryService = new InventoryService(inventoryDAO);
        Controller controller = new Controller(inventoryService);



        // customer flow; controller layer what do?
        CustomerDAO customerDAO = new CustomerDAO(conn);
        CustomerService customerService = new CustomerService(customerDAO);
//        Controller controller2 = CustomerController(customerService);



        controller.getAPI().start();


        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
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
                    "\n(12) Get all customers by city");

            int response = scan.nextInt();

            //            INVENTORY table UI
            if(response==1){
                // add item to service class
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
            }
            else if(response == 2){
                // query item from service class
                System.out.println("(2) QUERY: Enter name of item:");
                String item = scan.next();
                Inventory inventory = inventoryService.getItemByName(item);

                System.out.println("\n");
                System.out.println(inventory);
            }
            else if(response == 3){
                // delete item using service class
                System.out.println("(3) DELETE: Enter item: ");
                String item = scan.next();

                System.out.println("\n");
                inventoryService.deleteItem(item);
            }
            else if(response == 4){
                // update item using service class
                System.out.println("(4) UPDATE: Enter item: ");
                String item = scan.next();
                System.out.println("(4) UPDATE: Enter price: ");
                double price = scan.nextDouble();
                System.out.println("(4) UPDATE: Enter quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item , quantity);

                System.out.println("\n");
                inventoryService.updateItem(inventory);
            }
            else if(response == 5){
                // query all items from service class
                System.out.println("(5) QUERY: All items:\n");
                inventoryService.getAllItems();
                List<Inventory> inventoryList = inventoryService.getAllItems();

                System.out.println("\n");
                System.out.println(inventoryList);
            }
            else if(response == 6){
                // query type from service class
                System.out.println("(6) QUERY: Enter type: \n" +
                        "( produce / meat / baby_products / international / candy / animal_products / hygiene / paper_products )\n");
                String type = scan.next();
//                List<Inventory> inventory = inventoryService.getAllItemsByType(type);

                System.out.println("\n");
//                System.out.println(inventory);
            }

            //           CUSTOMER UI
            else if(response==7){
                // add customer to service class
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
            }




            else if(response == 8){
                // query all customers
                System.out.println("(8) QUERY: All customers:\n");
                customerService.getAllCustomers();
                List<Customer> customerList = customerService.getAllCustomers();

                System.out.println("\n");
                System.out.println(customerList);
            }
            else if(response == 9){
                // get customer by *ID*
                System.out.println("(9) QUERY: Enter customer id: \n");
                int customerId = scan.nextInt();
                Customer customer = customerService.getCustomerById(customerId);
                System.out.println(customer);

            }
            else if(response == 10){
                // get customer by *FIRST NAME*
                System.out.println("(10) QUERY: Enter customer first name: \n");
                String customerFirstName = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByFirstName(customerFirstName);
                System.out.println(customerList);

            }
            else if(response == 11){
                // get customer by *LAST NAME*
                System.out.println("(11) QUERY: Enter customer last name: \n");
                String customerLastName = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByLastName(customerLastName);
                System.out.println(customerList);

            }else if(response == 12){
                // query all customerS from a *CITY*
                System.out.println("(12) QUERY: Enter city: \n");
                String city = scan.next();
                List<Customer> customerList = customerService.getAllCustomersByCity(city);

                System.out.println("\n");
                System.out.println(customerList);
            }
            else{
                // invalid choice
                System.out.println("\n");
                System.out.println("Invalid choice: '" + response + "'\n");
            }

        }
    }
}