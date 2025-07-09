package ss10_stack_queue.BaiTap;

import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thập phân: ");
        int decimal = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        int number = decimal;

        while (number > 0) {
            int remainder = number % 2;
            stack.push(remainder);
            number /= 2;
        }

        System.out.print("Số nhị phân tương ứng là: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        if (decimal == 0) {
            System.out.print("0");
        }

        System.out.println();
    }
}

