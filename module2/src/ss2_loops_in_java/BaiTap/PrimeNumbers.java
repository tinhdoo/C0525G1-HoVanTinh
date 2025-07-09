package ss2_loops_in_java.BaiTap;

import java.util.Enumeration;
import java.util.Scanner;

public class PrimeNumbers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Nhập số lượng số nguyên tố cần in: ");
    int numbers = input.nextInt();
    int count = 0;
    int N = 2;
    System.out.println(numbers + " số nguyên tố đầu tiên là:");
    while (count < numbers) {
      if (isPrime(N)) {
        System.out.println(N);
        count++;
      }
      N++;
    }
  }

  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}

