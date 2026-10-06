package G2.WebsiteBanDT.models;

<<<<<<< HEAD
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
=======
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


    public Order() {} 

    public Order(int orderId, User user, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.totalAmount = totalAmount;
>>>>>>> main
        this.status = OrderStatus.CHO_XAC_NHAN;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
<<<<<<< HEAD
        System.out.println("Đơn hàng #" + orderId + " đã cập nhật trạng thái: " + newStatus);
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Cart getCart() { return cart; }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
}
=======
        System.out.println("Don hang #" + orderId + " da cap nhat trang thai: " + newStatus);
    }





    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}
>>>>>>> main
