package Controller;

import Model.Customer;
import Model.Inventory;
import Service.CustomerService;
import Service.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.List;

/**
 * Controller class responsible for handling HTTP requests and managing interactions between the API and services.
 */
public class Controller {
    private InventoryService inventoryService;

    /**
     * Initializes the Controller with an InventoryService.
     *
     * @param inventoryService The InventoryService to be used for managing inventory-related operations.
     */
    public Controller(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Retrieves the Javalin API instance for this controller.
     *
     * @return The Javalin API instance.
     */
    public Javalin getAPI() {
        Javalin app = Javalin.create();

        // INVENTORY interactions
        app.get("/inventory", this::getAllInventoryHandler);
        app.get("/inventory/{item}", this::getInventoryByNameHandler);
        app.get("/inventory/type/{type}", this::getAllInventoryByTypeHandler);

        app.post("/inventory", this::postInventoryHandler);
        app.put("/inventory", this::putInventoryHandler);

        // CUSTOMER interactions
        app.get("/customer", this::getAllCustomersHandler);
        app.get("/customer/city/{city}", this::getAllCustomersByCityHandler);
        app.post("/customer", this::postCustomerHandler);
        app.put("/customer", this::putCustomerHandler);

        return app;
    }

    private void getAllInventoryHandler(Context context) {
        List<Inventory> inventoryList = inventoryService.getAllItems();
        context.json(inventoryList);
    }

    private void getInventoryByNameHandler(Context context) {
        String item = context.pathParam("item");
        Inventory inventory = inventoryService.getItemByName(item);
        if (inventory == null) {
            context.status(404);
        } else {
            context.json(inventory);
        }
    }

    /**
     * Retrieve all inventory by type.
     *
     * @param context The HTTP context.
     */
    private void getAllInventoryByTypeHandler(Context context) {
        String type = context.pathParam("type");
        List<Inventory> inventory = inventoryService.getAllItemsByType(type);
        if (inventory == null) {
            context.status(404);
        } else {
            context.json(inventory);
        }
    }

    /**
     * Add new item
     * @param context
     */
    private void postInventoryHandler(Context context) {
        ObjectMapper om = new ObjectMapper();
        try {
            Inventory f = om.readValue(context.body(), Inventory.class);
            inventoryService.addItem(f);
            // resource created response
            context.status(201);
        } catch (JsonProcessingException e) {
            // if the JSON couldn't be processed, then the user sent us a faulty JSON,
            // so return a 400
            e.printStackTrace();
            context.status(400);
        }
    }

    /**
     * Update existing item's record
     * @param context
     */
    private void putInventoryHandler(Context context) {
        ObjectMapper om = new ObjectMapper();
        try {
            Inventory f = om.readValue(context.body(), Inventory.class);
            inventoryService.updateItem(f);
            // resource created response
            context.status(201);
        } catch (JsonProcessingException e) {
            // if the JSON couldn't be processed, then the user sent us a faulty JSON,
            // so return a 400
            e.printStackTrace();
            context.status(400);
        }
    }

    /**
     * Retrieve all existing customers
     * @param context
     */
    private void getAllCustomersHandler(Context context) {
        List<Customer> customerList = inventoryService.getAllCustomers();
        System.out.println(customerList);
        context.json(customerList);
    }

    /**
     * Retrieve all customers from specific city
     * @param context
     */
    private void getAllCustomersByCityHandler(Context context) {
        String city = context.pathParam("city");
        List<Customer> customerByCityList = inventoryService.getAllCustomersByCity(city);
        if (customerByCityList == null) {
            context.status(404);
        } else {
            context.json(customerByCityList);
        }
    }

    /**
     * Add new customer
     * @param context
     * @throws JsonProcessingException
     */
    private void postCustomerHandler(Context context) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        try {
            Customer c = om.readValue(context.body(), Customer.class);
            inventoryService.addCustomer(c);
            // resource created response
            context.status(201);

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update existing customer's record
     * @param context
     */
    private void putCustomerHandler(Context context) {
        ObjectMapper om = new ObjectMapper();
        try {
            Customer c = om.readValue(context.body(), Customer.class);
            inventoryService.updateCustomer(c);
            // resource created response
            context.status(201);
        } catch (JsonProcessingException e) {
            // if the JSON couldn't be processed, then the user sent us a faulty JSON,
            // so return a 400
            e.printStackTrace();
            context.status(400);
        }
    }
}
