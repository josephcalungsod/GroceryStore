package DAO;

import Model.Inventory;
import Model.Order;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;
    public OrderDAO (Connection conn){ this.conn = conn; }


    public void addItemToCart(Order order) {
    }

    public void removeItemFromCart(String item) {
    }

    public void updateItemInCart(Order order) {
    }

    public List<Order> viewAllItemsInCart() {
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }
}
