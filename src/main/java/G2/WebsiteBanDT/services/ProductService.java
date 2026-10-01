package G2.WebsiteBanDT.services;

import G2.WebsiteBanDT.models.Product;
import G2.WebsiteBanDT.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return productRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword, keyword);
        }
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product reduceStock(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + productId));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Số lượng tồn kho không đủ (Hiện còn: " + product.getStock() + ")");
        }

        product.setStock(product.getStock() - quantity);
        return productRepository.save(product);
    }
}