package ss16_binary_file_serialization.BaiTap.ManageProducts.model;

import java.io.Serial;
import java.io.Serializable;

public class Products implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private float code;
    private String name;
    private double price;
    private String Manufactured;
    private String status;

    public Products() {
    }

    public Products(float code, String name, double price, String manufactured, String status) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.Manufactured = manufactured;
        this.status = status;
    }

    public float getCode() {
        return code;
    }

    public void setCode(float code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getManufactured() {
        return Manufactured;
    }

    public void setManufactured(String manufactured) {
        Manufactured = manufactured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Products{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Manufactured='" + Manufactured + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
