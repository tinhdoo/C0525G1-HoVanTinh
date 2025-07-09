package ss10_stack_queue.BaiTap;

import java.util.Map;
import java.util.TreeMap;

public class Count {
    public static void main(String[] args) {
        String input = "Ho Van Tinh tinh tuoi cua tinh";
        String[] words = input.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new TreeMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (String key : wordCount.keySet()) {
            System.out.println(key + ": " + wordCount.get(key));
        }
    }
}
