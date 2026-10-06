package G2.WebsiteBanDT.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public Long userId;
    public double totalAmount;
    public String status; // "PENDING", "SHIPPING", "DELIVERED"
    public Date createdAt = new Date();
}