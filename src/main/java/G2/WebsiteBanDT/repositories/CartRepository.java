package G2.WebsiteBanDT.repositories;

import G2.WebsiteBanDT.models.CartItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {
    private final List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(CartItem item) {
        for (CartItem ci : cartItems) {
            if (ci.getProduct().getId().equals(item.getProduct().getId())) {
                ci.setQuantity(ci.getQuantity() + item.getQuantity());
                return;
            }
        }
        cartItems.add(item);
    }

    public void clearCart() {
        cartItems.clear();
    }
}