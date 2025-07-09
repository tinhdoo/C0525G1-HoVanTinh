package ss12_search_algorithm.BaiTap;

import java.util.Arrays;
import java.util.Scanner;
//đệ quy
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.print("Nhập số cần tìm: ");
        int num = scanner.nextInt();

        BinarySearch search = new BinarySearch();

        int index = search.binarySearch(array, 0, array.length - 1, num);

        if (index != -1) {
            System.out.println("Tìm thấy " + num + " tại vị trí: " + index);
        } else {
            System.out.println("Không tìm thấy " + num + " trong mảng.");
        }
    }
}
