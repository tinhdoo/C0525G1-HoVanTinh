package ss10;

import java.time.LocalDate;

public class Fruits {
    protected String name;
    protected String type;
    protected LocalDate productionDate;   // ngày sản xuất
    protected LocalDate expiry;   // hạn sử dụng
    protected String country;
    protected int price;

    public Fruits(String name, String type, LocalDate productionDate, LocalDate expiry, String country, int price) {
        this.name = name;
        this.type = type;
        this.productionDate = productionDate;
        this.expiry = expiry;
        this.country = country;
        this.price = price;
    }

    public Fruits() {
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
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", productionDate=" + productionDate +
                ", expiry=" + expiry +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
    public String addFruit(){
            return addFruit();
    }
}
