package ss11_java_collection_framework.BaiTap;

import ss16_binary_file_serialization.BaiTap.ManageProducts.model.Products;

public class Product extends Products {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, double price, String manufacturer, String description) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "product" + id + ", name= '" + name + "', price=" + price + '}';
    }
}
