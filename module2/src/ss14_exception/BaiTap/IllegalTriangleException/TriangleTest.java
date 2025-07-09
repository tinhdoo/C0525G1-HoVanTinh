package ss14_exception.BaiTap.IllegalTriangleException;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = inputSide("a", scanner);
        double b = inputSide("b", scanner);
        double c = inputSide("c", scanner);

        try {
            checkTriangle(a, b, c);
            System.out.println("Hợp lệ: Đây là một tam giác.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static double inputSide(String name, Scanner scanner) {
        double value = -1;
        while (true) {
            try {
                System.out.print("Nhập cạnh " + name + ": ");
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    throw new IllegalTriangleException("Cạnh " + name + " phải lớn hơn 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số.");
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
