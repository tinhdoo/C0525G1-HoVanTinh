package ss4_OOP.ThucHanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài: ");
        int width = scanner.nextInt();
        System.out.println("Nhập chiều cao: ");
        int height = scanner.nextInt();

        Rectangle rectangle = new Rectangle(height, width);
        System.out.println(rectangle.display()
);
        System.out.println("diện tích= " + rectangle.getArea());
        System.out.println("chu vi= " + rectangle.getPerimeter());
    }
}
