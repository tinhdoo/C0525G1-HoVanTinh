package ss11_java_collection_framework.BaiTap;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "Cà phê", 45000));
        manager.addProduct(new Product(2, "Trà sữa", 55000));
        manager.addProduct(new Product(3, "Sinh tố", 50000));

        System.out.println("== Danh sách sản phẩm ==");
        manager.displayProduct();

        System.out.println("== Sửa sản phẩm id = 2 ==");
        manager.editProduct(2, "Trà sữa", 50000);
        manager.displayProduct();

        System.out.println("== Xoá sản phẩm id = 1 ==");
        manager.removeProduct(1);
        manager.displayProduct();

        System.out.println("== Tìm sản phẩm chứa 'sữa' ");
        manager.displayProduct();

        System.out.println("== Sắp xếp tăng dần theo giá ==");
        manager.sortByPriceAscending();
        manager.displayProduct();

        System.out.println("== Sắp xếp giảm dần theo giá ==");
        manager.sortByPriceDescending();
        manager.displayProduct();
    }
}
