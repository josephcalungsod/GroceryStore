package Controller;

import Model.Customer;
import Model.Inventory;
import Service.CustomerService;
import Service.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class Controller {
    InventoryService inventoryService;
//    CustomerService customerService;


    public Controller(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

//    public Controller(CustomerService customerService) { this.customerService = customerService;}


    public Javalin getAPI() {
        Javalin app = Javalin.create();
//        this endpoints are RESTful because they identify a resource to work with (the 'flight' model)
//        they descriptively provide information on what the intended action is
//        they will interact with JSON formats of the flight data model
        app.get("/inventory", this::getAllInventoryHandler);
        app.get("/inventory/{item}", this::getInventoryByNameHandler);
        app.get("/inventory/type/{type}", this::getAllInventoryByTypeHandler);
        app.post("/inventory", this::postInventoryHandler);
        app.get("/qparam-example", this::qparamtest);
        app.put("/inventory", this::putInventoryHandler);
//        app.delete("/inventory/{item}", this::deleteInventoryHandler);

//        app.get("/customer", this::getAllCustomerHandler);

        return app;
    }

    private void getAllInventoryHandler(Context context){
        List<Inventory> inventoryList = inventoryService.getAllItems();
        context.json(inventoryList);
    }
    private void getInventoryByNameHandler(Context context){
        String item = context.pathParam("item");
        Inventory inventory = inventoryService.getItemByName(item);
        if(inventory == null){
            context.status(404);
        }else{
            context.json(inventory);
        }
    }

    /**
     * Retrieve all inventory by type
     * @param context
     */
    private void getAllInventoryByTypeHandler(Context context){
        String type = context.pathParam("type");
        List<Inventory> inventory= inventoryService.getAllItemsByType(type);
        if(inventory == null){
            context.status(404);
        }else{
            context.json(inventory);
        }
    }
    private void postInventoryHandler(Context context){
        ObjectMapper om = new ObjectMapper();
        try {
            Inventory f = om.readValue(context.body(), Inventory.class);
            inventoryService.addItem(f);
//            resource created response
            context.status(201);
        }catch(JsonProcessingException e){
//            if the json couldn't be processed, then the user sent us a faulty JSON,
//            so return a 400
            e.printStackTrace();
            context.status(400);
        }

    }
   
    private void putInventoryHandler(Context context){
        ObjectMapper om = new ObjectMapper();
        try {
            Inventory f = om.readValue(context.body(), Inventory.class);
            inventoryService.updateItem(f);
//            resource created response
            context.status(201);
        }catch(JsonProcessingException e){
//            if the json couldn't be processed, then the user sent us a faulty JSON,
//            so return a 400
            e.printStackTrace();
            context.status(400);
        }

    }
    private void qparamtest(Context context){
        String item = context.queryParam("Item");
        context.json(item);
    }


//Delete function is not desired,but passed the test.
//    private void deleteInventoryHandler(Context context){
//        String item = context.pathParam("item");
//        inventoryService.deleteItem(item);
//        Inventory inventory = inventoryService.getItemByName(item);
//        if(inventory == null){
//            context.status(404);
//        }else{
//            context.json(inventory);
//        }
//    }

    /**
     * customerService not working???
     */
//    private void getAllCustomerHandler(Context context){
//        List<Customer> customerList = customerService.getAllCustomers();
//        context.json(customerList);
//    }
}