package ss3_array.BaiTap;

import java.util.Scanner;

public class MergeArrays {
  //Gộp mảng
  public static void main(String[] args) {
    int[] arr = new int[3];
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
      arr[i] = scanner.nextInt();
    }

    int[] arr2 = new int[4];
    Scanner scanner1 = new Scanner(System.in);
    for (int i = 0; i < 4; i++) {
      System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
      arr2[i] = scanner.nextInt();
    }

    int[] arr3 = new int[arr.length + arr2.length];

    for (int i = 0; i < arr.length; i++) {
      arr3[i] = arr[i];
    }
    for (int i = 0; i < arr2.length; i++) {
      arr3[arr.length + i] = arr2[i];
    }
    System.out.println("Mảng sau khi gộp là:");
    for (int num : arr3) {
      System.out.print(num + " ");
    }
  }
}
