package ss3_array.BaiTap;

import java.util.Scanner;

public class SmallestValue {
  public static void main(String[] args) {
    int size;
    int[] array;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.print("Nhập kích thước:");
      size = scanner.nextInt();

    } while (size > 20);
    array = new int[size];
    int i = 0;
    while (i < array.length) {
      System.out.print("Nhập giá trị phần tử: " + (i + 1) + ": ");
      array[i] = scanner.nextInt();
      i++;
    }

    int min = array[0];
    for (int j = 1; j < array.length; j++) {
      if (min > array[j]) {
        min = array[j];
      }
    }
    System.out.println("Giá trị nhỏ nhất là: " + min);
  }
}
