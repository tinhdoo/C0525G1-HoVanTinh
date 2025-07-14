package ss12.model;

import ss12.service.IFruits;

import java.time.LocalDate;

public class Fruits {
    private int id;
    private String name;
    private String type;
    private LocalDate productionDate;   // ngày sản xuất
    private LocalDate expiry;   // hạn sử dụng
    private String country;
    private int price;

    public Fruits(int id, String name, String type, LocalDate productionDate, LocalDate expiry, String country, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.productionDate = productionDate;
        this.expiry = expiry;
        this.country = country;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", productionDate=" + productionDate +
                ", expiry=" + expiry +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
