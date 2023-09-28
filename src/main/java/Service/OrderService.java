package Service;

import DAO.OrderDAO;
import Model.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public void addItemToCart(Order order){
        orderDAO.addItemToCart(order);
    }
    public void removeItemFromCart(String item){
        orderDAO.removeItemFromCart(item);

    }
    public void updateItemInCart(Order order){
        orderDAO.updateItemInCart(order);

    }
    public List<Order> viewAllItemsInCart(){
        List<Order> allItemsInCart = orderDAO.viewAllItemsInCart();
        return allItemsInCart;
    }
}
