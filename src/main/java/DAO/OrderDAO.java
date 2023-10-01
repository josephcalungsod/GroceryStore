package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Model.Customer;
import Model.Inventory;
import Model.Order;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;
    public OrderDAO (Connection conn){ this.conn = conn; }
    Order order;

    public void addItemToCart(Order order) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO orders ( orderContent, orderDate, customerId) VALUES (?, ?, ?)");
            String contentAsString = String.join(", ", order.getOrderContent());

            ps.setString(1, contentAsString);
            ps.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setInt(3, order.getCustomerId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static Customer getOrderByCustomerID(int id) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders " +
//                    "inner join customer " +
//                    "ON orders.customerId = customer.customer_id " +
//                    "WHERE orders.customerId = ?");
//            ps.setInt(1, id);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                int dbCustomerId = rs.getInt("customer_id");
//                String dbCustomerFirstname = rs.getString("first_name");
//                String dbCustomerLastName = rs.getString("last_name");
//                String dbCustomerCity = rs.getString("city");
//                int dbZipcode = rs.getInt("zip_code");
//
//                Customer dbCustomerOder = new Customer(dbCustomerId, dbCustomerFirstname, dbCustomerLastName, dbCustomerCity, dbZipcode);
//                return dbCustomerOder;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void removeItemFromCart(String item) {
//    }

    public void updateItemInCart(Order order) {
    }

    public List<Order> viewAllItemsInCart() {
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }
}
