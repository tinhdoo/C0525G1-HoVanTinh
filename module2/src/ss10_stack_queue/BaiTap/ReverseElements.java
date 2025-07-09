package ss10_stack_queue.BaiTap;

import java.util.Stack;

public class ReverseElements {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};

        Stack<Integer> stack = new Stack<>();
        for (int num : numbers){
            stack.push(num);
        }

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = stack.pop();
        }

        for (int num : numbers){
            System.out.println(num + " ");
        }
    }
}
