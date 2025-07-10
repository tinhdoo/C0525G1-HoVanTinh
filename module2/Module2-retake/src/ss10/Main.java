package ss10;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Fruits[] fruits = new Fruits[5];
        fruits[0] = new Fruits("Táo", "Ngon", LocalDate.of(2025,7,5), LocalDate.of(2025,8,29), "Việt Nam", 200000 );
        fruits[1] = new Fruits("Ổi", "Ngon", LocalDate.of(2025,7,3), LocalDate.of(2025,8,29), "Nhật Bản", 150000 );
        fruits[2] = new Fruits("Xoài", "Ngon", LocalDate.of(2025,6,12), LocalDate.of(2025,8,29), "Trung Quốc", 120000 );
        fruits[3] = new Fruits("Dưa hấu", "Ngon", LocalDate.of(2025,1,25), LocalDate.of(2025,8,29), "Campuchia", 340000 );
        fruits[4] = new Fruits("Nho", "Ngon", LocalDate.of(2025,7,5), LocalDate.of(2025,8,29), "Mỹ", 200000 );

        for (Fruits fruit : fruits ) {
            System.out.print(fruit.getName() + " - ");
            System.out.print(fruit.getType() + " - ");
            System.out.print(fruit.getProductionDate() + " - ");
            System.out.print(fruit.getCountry() + " - ");
            System.out.print(fruit.getPrice());
            System.out.println();

        }
    }
}