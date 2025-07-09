package ss3_array.BaiTap;

import java.util.Scanner;

public class SumDiagonal {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nhập số dòng của ma trận (dòng phải bằng cột): ");
    int rows = scanner.nextInt();
    System.out.print("Nhập số cột của ma trận (cột phải bằng dòng): ");
    int cols = scanner.nextInt();

    if (rows != cols) {
      System.out.println("Lỗi: Ma trận không phải hình vuông!");
      return;
    }

    double[][] matrix = new double[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.printf("Nhập phần tử tại dòng %d - cột %d: ", i, j);
        matrix[i][j] = scanner.nextDouble();
      }
    }


    double sum = 0;
    for (int i = 0; i < rows; i++) {
      sum += matrix[i][i];
    }

    System.out.println("Ma trận bạn vừa nhập là:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("Tổng các phần tử ở đường chéo chính: " + sum);
  }
}
