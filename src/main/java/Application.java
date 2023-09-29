import Controller.Controller;
import DAO.InventoryDAO;
import Model.Inventory;
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
                    "\n(6) View Inventory by Type\n");

            int response = scan.nextInt();

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
//                System.out.println("(4) UPDATE: Enter price: ");
//                double price = scan.nextDouble();
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
                List<Inventory> inventory = inventoryService.getAllItemsByType(type);

                System.out.println("\n");
                System.out.println(inventory);
            }
            else{
                // invalid choice
                System.out.println("\n");
                System.out.println("Invalid choice: '" + response + "'\n");
            }

        }
    }
}