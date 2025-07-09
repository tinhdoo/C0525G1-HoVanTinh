package ss2_loops_in_java.ThucHanh;

import java.util.Scanner;

public class CheckPrimeNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số cần kiểm tra: ");
    int a = scanner.nextInt();

    if (a <= 1) {
      System.out.println("Số vừa nhập không phải số nguyên tố");
    } else {
      boolean isPrime = true;
      for (int i = 2; i <= Math.sqrt(a); i++) {
        if (a % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.println("Số vừa nhập là số nguyên tố");
      } else {
        System.out.println("Số vừa nhập không phải số nguyên tố");
      }
    }
  }
}
