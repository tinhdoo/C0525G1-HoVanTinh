package ss14_exception.ThucHanh;

import ss1_introduction_to_java.ThucHanh.TinhChiSoCanNang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numerator: ");
        try {
            int numerator = scanner.nextInt();
            System.out.printf("Denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;
            System.out.printf("\nResult: %d / %d = %d \n", numerator, denominator, result);
        } catch (InputMismatchException ime) {
            System.out.printf("Vui long nhap so vao");
        }
    }
}
