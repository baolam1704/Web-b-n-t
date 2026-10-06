package G2.WebsiteBanDT.repositories;

import G2.WebsiteBanDT.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}