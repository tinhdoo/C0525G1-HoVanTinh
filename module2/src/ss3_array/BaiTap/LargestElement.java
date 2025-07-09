package ss3_array.BaiTap;

import java.util.Scanner;

//Tìm phẩn tử lớn nhất trong mảng 2 chiều
public class LargestElement {
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


    System.out.println("Ma trận bạn vừa nhập là:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    double max = matrix[0][0];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (max < matrix[i][j]) {
          max = matrix[i][j];
        }
      }
    }
    System.out.println("Phần tử lớn nhất là : " + max);
  }
}

