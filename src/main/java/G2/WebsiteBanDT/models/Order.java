package G2.WebsiteBanDT.models;

import G2.OrderStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private double totalAmount;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {} // Constructor rỗng bắt buộc cho JPA

    public Order(int orderId, User user, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CHO_XAC_NHAN;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Don hang #" + orderId + " da cap nhat trang thai: " + newStatus);
    }

    // Getters và Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}