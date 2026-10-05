package G2;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Order> orderList = new ArrayList<>();

    public void displayAllOrders() {
        System.out.println("=== DANH SÁCH ĐƠN HÀNG ===");
        for (Order order : orderList) {
            System.out.println("Mã đơn: " + order.getOrderId() + 
                               " | Tổng tiền: " + order.getTotalAmount() + 
                               " | Trạng thái: " + order.getStatus());
        }
    }

    public void updateOrderStatus(int orderId, OrderStatus newStatus) {
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                order.updateStatus(newStatus);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với mã: " + orderId);
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : orderList) {
            if (order.getStatus() == OrderStatus.DA_GIAO) {
                totalRevenue += order.getTotalAmount();
            }
        }
        return totalRevenue;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
}
