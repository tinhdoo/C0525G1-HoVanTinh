package common;

import java.util.Scanner;

public class InputArrays {
    public static int[] inputArray() {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước: ");
            size = scanner.nextInt();

        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập giá trị phần tử: " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    public static int[][] input2DArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số dòng: ");
        int m = scanner.nextInt();

        System.out.print("Nhập số cột: ");
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];

        // Nhập giá trị cho từng phần tử
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }
}
