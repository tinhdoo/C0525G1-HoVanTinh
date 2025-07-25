package ss2;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int numA = 0;
        int numB = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        numA = scanner.nextInt();
        System.out.print("Nhập số b: ");
        numB = scanner.nextInt();

        int gcd = findGreatestCommonDivisor(numA, numB);
        System.out.println("Ước chung lớn nhất: " + gcd);

        int scm = findSmallestCommonMultiple(numA, numB);
        System.out.println("Bội chung nhỏ nhất: " + scm);

        double average = (double) (gcd + scm) /2;
        System.out.println("Trung bình cộng: " + average);

    }

    public static int findGreatestCommonDivisor(int numA, int numB) {
        int gcd = 1;
        int min = Math.min(numA, numB);

        for (int i = 1; i <= numA; i++) {
            if (numA % i == 0 && numB % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
    public static int findSmallestCommonMultiple(int numA, int numB){
        int max = Math.max(numA, numB);
        while (true){
            if (max % numA == 0 && max % numB == 0){
                return max;
            }
            max++;
        }
    }
}

