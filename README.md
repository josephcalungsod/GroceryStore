# Web API connected to a database.

<h2># Grocery Store Inventory System.</h2>

A Maven web application to manage, track, and access inventory and customer details for a grocery store. It can work both locally (in CLI) and remotely (on Postman).

<h3>## Endpoints</h3>

- **localhost:8080**
  - `/inventory` - Get all inventory info.
  - `/inventory/apple` - Get inventory by item, such as apple, banana...
  - `/inventory/type/{type}` - Get inventory by type, such as produce, meat...
  - `/customer` - Get all customer info.
  - `/customer/city/{city}` - Get customer's info by ID.(1, 2, 3...)/by city/by name/by zip code

<h4>## Key Features</h4>

<h4>### Inventory Management</h4>

1. **Add New Item**
   - Add items seamlessly.
   - Fields:
     - Item Name
     - Type
     - Price
     - Quantity

2. **Update Item Details**
   - Make necessary modifications to item data.
   - Fields:
     - Item Name
     - Quantity

3. **Delete Item**
   - Remove items from the inventory database.

4. **Retrieve Item Information**
   - View details of specific items.
   - Display:
     - Name
     - Type
     - Price
     - Quantity
   - Additional Info:
     - Item ID
     - Farm Name
     - Brand
     - Contact Info

5. **Full Inventory Overview**
   - A holistic view of all inventory items.
   - Display:
     - Name
     - Type
     - Price
     - Quantity
   - Additional Info:
     - Item ID
     - Farm Name
     - Brand
     - Contact Info

6. **Filter Items by Type**
   - Categorize items by type for better viewing.
   - Display:
     - Name
     - Type
     - Price
     - Quantity
   - Additional Info:
     - Item ID
     - Farm Name
     - Brand
     - Contact Info

<h4>### Customer Management</h4>

7. **Add Customer**
   - Register new customers to the system.
   - Fields:
     - Customer ID (auto-incremented)
     - First Name
     - Last Name
     - City
     - Zip Code

8. **View All Customers**
   - A list of all registered customers.
   - Display:
     - Customer ID
     - First Name
     - Last Name
     - City
     - Zip Code

9. **Retrieve Customer by ID**
   - Get specific details of a customer using their ID.
   - Display:
     - Customer ID
     - First Name
     - Last Name
     - City
     - Zip Code

10. **Filter Customers by First Name**
    - List customers based on their first name.
    - Display:
      - Customer ID
      - First Name
      - Last Name
      - City
      - Zip Code

11. **Filter Customers by Last Name**
    - List customers based on their last name.
    - Display:
      - Customer ID
      - First Name
      - Last Name
      - City
      - Zip Code

12. **Filter Customers by City**
    - List customers based on their city.
    - Display:
      - Customer ID
      - First Name
      - Last Name
      - City
      - Zip Code

<h4>## Database Architecture</h4>

Our system is backed by three main tables:

1. **grocery_store**: Basic details of items.
   - PK: `item` (e.g., *milk*)
   - Fields:
     - Item
     - Type
     - Price
     - Quantity

2. **grocery_info**: Additional information related to items.
   - PK: `item_id` (e.g., *1*)
   - FK: `item` (References **grocery_store**)
   - Fields:
     - Item ID
     - Farm Name
     - Brand
     - Contact

3. **customer**: Central table for customer data.
   - PK: `customer_id` (e.g., *1*)
   - Fields:
     - Customer ID
     - First Name
     - Last Name
     - City
     - Zip Code
