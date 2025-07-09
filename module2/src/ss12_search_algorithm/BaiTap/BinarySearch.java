package ss12_search_algorithm.BaiTap;

public class BinarySearch {

    public BinarySearch() {
    }

    public int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return binarySearch(array, left, mid - 1, value);
        } else {
            return binarySearch(array, mid + 1, right, value);
        }
    }
}
