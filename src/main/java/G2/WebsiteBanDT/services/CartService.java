package G2.WebsiteBanDT.services;

import G2.WebsiteBanDT.models.CartItem;
import G2.WebsiteBanDT.models.Product;
import G2.WebsiteBanDT.repositories.CartRepository;
import G2.WebsiteBanDT.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getCartItems() {
        return cartRepository.getCartItems();
    }

    public boolean addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartRepository.addItem(new CartItem(product, quantity));
            return true;
        }
        return false;
    }

    public java.math.BigDecimal getTotalAmount() {
        return cartRepository.getCartItems().stream()
                .map(CartItem::getTotalPrice)
                .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
    }
}