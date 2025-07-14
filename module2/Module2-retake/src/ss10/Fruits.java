package ss10;

import java.time.LocalDate;
import java.util.Scanner;
import static ss10.Main.fruits;

public class Fruits {
    private String name;
    private String type;
    private LocalDate productionDate;   // ngày sản xuất
    private LocalDate expiry;   // hạn sử dụng
    private String country;
    private int price;

    public Fruits(String name, String type, LocalDate productionDate, LocalDate expiry, String country, int price) {
        this.name = name;
        this.type = type;
        this.productionDate = productionDate;
        this.expiry = expiry;
        this.country = country;
        this.price = price;
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
    public static void add(Fruits fruit){
        fruits.add(fruit);

    }
    public static void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên trái cây: ");
        String name = scanner.nextLine().trim();
        System.out.println("Nhập loại: ");
        String  type = scanner.nextLine();

        System.out.println("Ngày sản xuất: " + LocalDate.now());
        LocalDate productionDate = LocalDate.now();

        System.out.println("Nhập hạn sử dụng (ngày): ");
        LocalDate expiry = LocalDate.now().plusDays(scanner.nextLong());


        System.out.println("Nhập xuất sứ: ");
        scanner.nextLine();
        String country = scanner.nextLine();
        System.out.println("Nhập giá: ");
        int price = scanner.nextInt();

        Fruits fruits = new Fruits(name,type,productionDate,expiry,country,price);
        add(fruits);
    }
}
