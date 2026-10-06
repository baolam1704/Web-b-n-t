package G2.WebsiteBanDT.controllers;

import G2.WebsiteBanDT.models.Order;
import G2.WebsiteBanDT.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping("/checkout")
    public Order createOrder(@RequestBody Order order) {
        order.status = "PENDING"; // Trạng thái mặc định chờ duyệt
        return orderRepo.save(order);
    }
}