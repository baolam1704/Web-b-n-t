package G2.WebsiteBanDT.controllers;

import G2.WebsiteBanDT.models.CartItem;
import G2.WebsiteBanDT.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // API 1: Xem/Kiểm tra giỏ hàng của khách
    @GetMapping
    public ResponseEntity<Map<String, Object>> getCart() {
        List<CartItem> items = cartService.getCartItems();
        java.math.BigDecimal totalAmount = cartService.getTotalAmount();

        Map<String, Object> response = new HashMap<>();
        response.put("items", items);
        response.put("totalAmount", totalAmount);
        response.put("totalItems", items.size());

        return ResponseEntity.ok(response);
    }

    // API 2: Thêm sản phẩm vào giỏ
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        boolean success = cartService.addToCart(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Đã thêm sản phẩm vào giỏ hàng thành công!");
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy sản phẩm với ID: " + productId);
        }
    }
}