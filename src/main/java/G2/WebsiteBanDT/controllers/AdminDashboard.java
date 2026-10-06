package G2.WebsiteBanDT.controllers;

import G2.WebsiteBanDT.models.*;
import G2.WebsiteBanDT.services.*;
import java.util.Scanner;

public class AdminDashboard {
    private AdminService adminService;

    public AdminDashboard(AdminService adminService) {
        this.adminService = adminService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n========== TRANG QUẢN TRỊ (ADMIN) ==========");
            System.out.println("1. Xem danh sách đơn hàng");
            System.out.println("2. Cập nhật trạng thái đơn hàng");
            System.out.println("3. Xem thống kê tổng doanh thu");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> adminService.displayAllOrders();
                case 2 -> {
                    System.out.print("Nhập mã đơn hàng: ");
                    int orderId = scanner.nextInt();
                    System.out.println("Chọn trạng thái: 1. DA_XAC_NHAN | 2. DANG_GIAO | 3. DA_GIAO | 4. HUY");
                    int st = scanner.nextInt();
                    OrderStatus status = switch (st) {
                        case 1 -> OrderStatus.DA_XAC_NHAN;
                        case 2 -> OrderStatus.DANG_GIAO;
                        case 3 -> OrderStatus.DA_GIAO;
                        case 4 -> OrderStatus.HUY;
                        default -> OrderStatus.CHO_XAC_NHAN;
                    };
                    adminService.updateOrderStatus(orderId, status);
                }
                case 3 -> System.out.println("-> TỔNG DOANH THU: " + adminService.calculateTotalRevenue() + " VNĐ");
                case 0 -> System.out.println("Thoát trang Admin.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}