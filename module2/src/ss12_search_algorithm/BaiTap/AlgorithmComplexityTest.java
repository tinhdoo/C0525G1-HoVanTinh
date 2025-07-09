package ss12_search_algorithm.BaiTap;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        int[] frequentChar = new int[255];                         //{1}
        for (int i = 0; i < inputString.length(); i++) {           //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);               //{3}
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                              //{4}
        }

        int max = 0;                                             //{5}
        char character = (char) 255; /* empty character */      //{6}
        for (int j = 0; j < 255; j++) {                         //{7}
            if (frequentChar[j] > max) {                        //{8}
                max = frequentChar[j];                          //{9}
                character = (char) j;                           //{10}
            }
        }
        System.out.println("The most appearing letter is'" + character + "'with a frequecy of " + max + "times");
    }
    /*
     * Các dòng {1}, {3}, {4}, {5}, {6}, {8}, {9}, {10} là phép gán hoặc so sánh đơn → O(1)
     *
     * {2}: Vòng lặp duyệt qua chuỗi có độ dài n → O(n)
     * {7}: Vòng lặp duyệt mảng 255 phần tử → O(255) ≈ O(1)
     *
     * ⇒ Tổng thời gian:
     *     - Nếu n ≤ 255 → chi phí lớn nhất là O(255) ⇒ O(1)
     *     - Nếu n > 255 → chi phí lớn nhất là O(n)
     *     ⇒ Kết luận tổng quát: O(n)
     *
     * ⇒ Bộ nhớ: chỉ dùng mảng cố định 255 phần tử và vài biến đơn → O(1)
     *
     * ➤ Time complexity: O(n)
     * ➤ Space complexity: O(1)
     */


}
