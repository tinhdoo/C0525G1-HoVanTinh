package ss13.controller;

import ss13.service.ImplSpend;
public class SpendController {
    ImplSpend implSpend = new ImplSpend();
    public void menuSpend(){
        System.out.println("Menu");
        System.out.println("1. Danh sách chi tiêu");
        System.out.println("2. Thêm chi tiêu");
        System.out.println("3. Xoá chi tiêu");
        System.out.println("4. Sửa chi tiêu");
        System.out.println("5. Tìm kiếm theo mã");
        System.out.println("6. Tìm kiếm gần đúng theo tên");
        System.out.println("0. Thoát chương trình");
        System.out.println("Chọn chức năng: ");
        implSpend.choose();
    }
}
