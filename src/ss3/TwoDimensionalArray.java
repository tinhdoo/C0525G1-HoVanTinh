package ss3;
public class TwoDimensionalArray {

    public static double average(int[][] arr) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 == 0) {
                    sum += arr[i][j];
                    count++;
                }
            }
        }

        if (count == 0) return 0;
        return (double) sum / count;
    }

    public static void main(String[] args) {
        int[][] array = {
                {2, 3, 6},
                {5, 8, 9},
                {4, 7, 10}
        };

        double result = average(array);
        System.out.println("Trung bình cộng các số chẵn là: " + result);
    }
}

