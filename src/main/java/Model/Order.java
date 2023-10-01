package Model;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int orderId;
//    orderDate format: YYYYMMDD
    private Date orderDate;
    private ArrayList<String> orderContent;
    private int customerId;


    public Order ( Date orderDate, ArrayList<String> orderContent, int customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.orderContent=orderContent;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", order_content=" + orderContent +
                ", customerId=" + customerId +
                '}';
    }

    public ArrayList<String> getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(ArrayList<String> orderContent) {
        this.orderContent = orderContent;
    }

    }

