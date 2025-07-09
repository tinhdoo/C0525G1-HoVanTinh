package ss13_sorting_algorithm.BaiTap;

public class InsertionSort {
    public static void InsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;

            System.out.print("Bước " + i + ": ");
            printArray(a);
        }
    }

    public static void insertionSort(int [] list){
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > currentElement) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = currentElement;
        }
    }

    public static void printArray(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
