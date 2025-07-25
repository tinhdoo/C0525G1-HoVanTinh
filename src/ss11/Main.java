package ss11;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số cần kiểm tra: ");
        int number = sc.nextInt();

        Stack<Integer> stack = Prime.stackPrime(number);
        Queue<Integer> queue = Prime.queuePrime(number);

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }
}
