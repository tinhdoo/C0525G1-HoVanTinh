package ss11_java_collection_framework.BaiTap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ProductManager {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void editProduct(int id, String newName, double newPrice){
        for (Product product : productList){
            if (product.getId() == id){
                product.setName(newName);
                product.setPrice(newPrice);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với id: " + id);
    }
    public void removeProduct(int id){
        productList.removeIf(product -> product.getId() == id);
    }
    public void displayProduct(){
        for (Product product : productList){
            System.out.println(product);
        }
    }

    public void searchByName(String name){
        for (Product product : productList){
            if (product.getName().toLowerCase().contains(name.toLowerCase()))

                System.out.println(product);
        }
    }

    public void sortByPriceAscending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
