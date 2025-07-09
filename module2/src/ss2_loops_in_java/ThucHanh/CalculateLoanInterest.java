package ss2_loops_in_java.ThucHanh;

import java.util.Scanner;

public class CalculateLoanInterest {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số tiền cho vay: ");
    double amount = scanner.nextDouble();

    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Nhập lãi suất: ");
    double rate = scanner1.nextDouble();

    Scanner scanner2 = new Scanner(System.in);
    System.out.println("Nhập thời gian vay (Tháng): ");
    int month = scanner2.nextInt();

    double totalInterest = 0;
    for (int i = 0; i < month; i++) {
      totalInterest += amount * (rate / 100) / 12 * month;
    }
    System.out.print(totalInterest);
  }
}
