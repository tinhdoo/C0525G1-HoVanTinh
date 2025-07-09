package ss10_stack_queue.BaiTap;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello world";

        Stack<String> wordStack = new Stack<>();
        String[] words = input.split(" ");

        for (String word : words){
            wordStack.push(word);
        }

        StringBuilder reversed = new StringBuilder();
        while (!wordStack.isEmpty()){
            reversed.append(wordStack.pop()).append(" ");
        }

        System.out.println("Reversed: " + reversed.toString().trim());
    }
}
