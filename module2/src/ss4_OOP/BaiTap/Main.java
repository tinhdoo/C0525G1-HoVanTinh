package ss4_OOP.BaiTap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = inputDouble(scanner, "Nhập a (khác 0): ", true);
        double b = inputDouble(scanner, "Nhập b: ", false);
        double c = inputDouble(scanner, "Nhập c: ", false);

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();

        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm:");
            System.out.println("x1 = " + equation.getRoot1());
            System.out.println("x2 = " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("x = " + equation.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm.");
        }
    }

    public static double inputDouble(Scanner scanner, String message, boolean mustNonZero) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (mustNonZero && value == 0) {
                    System.out.println("Giá trị phải khác 0. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } else {
                System.out.println("Vui lòng nhập số hợp lệ!");
                scanner.next();
            }
        }
        return value;
    }
}
