package ss10_stack_queue.BaiTap;

import java.util.*;

public class CheckPalindromeStringUsingQueue {
    public static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        input = input.replaceAll("\\s+", "").toLowerCase();

        for (char c : input.toCharArray()) {
            stack.push(c);
            queue.offer(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String str = scanner.nextLine();

        if (isPalindrome(str)) {
            System.out.println("=> Đây là chuỗi Palindrome.");
        } else {
            System.out.println("=> Không phải chuỗi Palindrome.");
        }
    }
}

