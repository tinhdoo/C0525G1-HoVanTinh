package ss1;

import java.util.Scanner;

public class Caculator {
    public static void main(String[] args) {
        int numA = 0;
        int numB = 0;
        int operator;
        int answer = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số a: ");
            numA = scanner.nextInt();
            System.out.print("Nhập số b: ");
            numB = scanner.nextInt();
            System.out.print("Chọn phép tính: ");
            System.out.println("1. Cộng ");
            System.out.println("2. Trừ ");
            System.out.println("3. Nhân ");
            System.out.println("4. Chia ");
            operator = scanner.nextInt();

            switch (operator) {
                case 1:
                    answer = numA + numB;
                    break;
                case 2:
                    answer = numA - numB;
                    break;
                case 3:
                    answer = numA * numB;
                    break;
                case 4:
                    answer = numA / numB;
                    break;
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Kết quả: "  +  answer);
            System.out.println("--------------------------------------------------");

        }
    }
}

