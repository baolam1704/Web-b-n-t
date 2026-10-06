package G2.WebsiteBanDT.models;

import G2.WebsiteBanDT.*;

public class Order {
    private int orderId;
    private Customer customer;
    private Cart cart;
    private double totalAmount;
    private OrderStatus status;

    public Order(int orderId, Customer customer, Cart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
        this.status = OrderStatus.CHO_XAC_NHAN;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Đơn hàng #" + orderId + " đã cập nhật trạng thái: " + newStatus);
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Cart getCart() { return cart; }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
}
