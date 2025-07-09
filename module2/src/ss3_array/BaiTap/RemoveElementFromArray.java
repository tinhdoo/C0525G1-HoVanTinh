package ss3_array.BaiTap;

import java.util.Scanner;

public class RemoveElementFromArray {
  // Xoá phẩn tử khỏi mảng
  public static void main(String[] args) {
    int[] array = {3, 4, 5, 6, 6};
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập phần tử cần xoá: ");
    int number = scanner.nextInt();

    boolean found = false;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == number) {
        array = remove(array, i);
        found = true;
        break;
      }
    }
    if (found) {
      System.out.println("Mảng sau khi xoá: ");
      for (int num : array) {
        System.out.print(num + " ");
      }
    } else {
      System.out.println("Không tìm thấy phần tử cần xoá!");
    }
  }
  public static int[] remove(int[] array, int index) {
    int[] newArr = new int[array.length - 1];
    for (int k = 0, j = 0; k < array.length; k++) {
      if (k != index) {
        newArr[j++] = array[k];
      }
    }
    return newArr;
  }
}
