package ss3;

import java.util.Scanner;

public class AverageII {
    public static void main(String[] args) {
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
        int sum = 0;
        int total = 0;
        int avg = 0;
        for (int j = 0; j < array.length; j++){
            if (j % 2 != 0){
                sum += array[j];
                total++;
            }
        }
        avg = sum / total;
        System.out.println("Trung bình cộng các số nguyên ở vị trí lẻ là: " + avg);
    }
}
