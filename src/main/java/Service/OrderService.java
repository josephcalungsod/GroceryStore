package Service;

import DAO.OrderDAO;
import Model.Customer;
import Model.Order;
import Util.LogUtil;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO=orderDAO;
        LogUtil.log.info("setting up order service");
    }

    public void addItemToCart(Order order){
        orderDAO.addItemToCart(order);
        LogUtil.log.info("adding item to cart");
    }

//    public void removeItemFromCart(String item){
//        orderDAO.removeItemFromCart(item);
//        LogUtil.log.info("removing item from cart");
//
//    }
    public void updateItemInCart(Order order){
        orderDAO.updateItemInCart(order);
        LogUtil.log.info("updating item in cart");
    }
    public List<Order> viewAllItemsInCart(){
        List<Order> allItemsInCart = orderDAO.viewAllItemsInCart();
        LogUtil.log.info("getting all items in cart");
        return allItemsInCart;
    }
}
