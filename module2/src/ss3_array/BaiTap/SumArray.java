package ss3_array.BaiTap;

import java.util.Scanner;

public class SumArray {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nhập số dòng của ma trận: ");
    int rows = scanner.nextInt();

    System.out.print("Nhập số cột của ma trận: ");
    int cols = scanner.nextInt();


    double[][] matrix = new double[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.printf("Nhập phần tử tại dòng %d - cột %d" + " ", i, j);
        matrix[i][j] = scanner.nextDouble();
      }
    }

    Scanner scanner1 = new Scanner(System.in);
    System.out.print("Nhập cột muốn tính tổng (tính từ 0): ");
    int colToSum = scanner1.nextInt();

    if (colToSum < 0 || colToSum >= cols) {
      System.out.println("Cột không hợp lệ!");
      return;
    }

    double sum = 0;
    for (int i = 0; i < rows; i++) {
      sum += matrix[i][colToSum];
    }
    System.out.println("Ma trận bạn vừa nhập là:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("Tổng các phần tử ở cột " + colToSum + " là: " + sum);
  }
}
