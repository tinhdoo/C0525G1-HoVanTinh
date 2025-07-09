package ss3;

import java.util.Scanner;

public class FindExistence {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 6, 7, 9, 12, 33, 45};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số bất kỳ: ");
        int num = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < numbers.length; i++ ) {
            if (numbers[i] == num) {
                System.out.println("Số " + num + " xuất hiện ở vị trí: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tồn tại!");
        }
    }

}
