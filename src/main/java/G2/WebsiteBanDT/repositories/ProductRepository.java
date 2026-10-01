package G2.WebsiteBanDT.repositories;

import G2.WebsiteBanDT.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand);

    List<Product> findByBrandIgnoreCase(String brand);
}