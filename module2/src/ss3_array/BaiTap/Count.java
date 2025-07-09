package ss3_array.BaiTap;

import java.util.Scanner;

public class Count {
  public static void main(String[] args) {
    String[] str = {"c", "o", "d", "e"};

    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập ký tự cần kiểm tra: ");
    String var = scanner.next();

    int count = 0;
    for (String s : str) {
      if (var.equals(s)) {
        count++;
      }
    }
    System.out.println("Số lần xuất hiện của \"" + var + "\": " + count);
  }
}
