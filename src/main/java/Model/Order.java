package Model;
public class Order {

    private int orderId;
//    orderDate format: YYYYMMDD
    private int orderDate;
    private int customerId;


    public Order (int orderId, int orderDate, int customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(int orderDate) {
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
                ", customerId=" + customerId +
                '}';
    }
}
