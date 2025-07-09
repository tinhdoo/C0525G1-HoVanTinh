package ss16_binary_file_serialization.BaiTap.ManageProducts.repository;

import ss16_binary_file_serialization.BaiTap.ManageProducts.model.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_PATH = "product.dat";

    public void addProduct(Products product) {
        List<Products> productList = readProducts();
        productList.add(product);
        writeProducts(productList);
    }

    public List<Products> readProducts() {
        List<Products> productList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return productList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            productList = (List<Products>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public void writeProducts(List<Products> productList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAll() {
        List<Products> productList = readProducts();
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Products product : productList) {
                System.out.println(product);
            }
        }
    }

    public void searchByName(String keyword) {
        List<Products> productList = readProducts();
        boolean found = false;
        for (Products product : productList) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào với từ khóa: " + keyword);
        }
    }
}
