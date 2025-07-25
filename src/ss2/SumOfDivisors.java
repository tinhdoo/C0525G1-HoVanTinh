package ss2;

import java.util.Scanner;

public class SumOfDivisors {
    public static void main(String[] args) {
        int num = 0;
        int sum = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số cần tính: ");
            num = scanner.nextInt();


        for (int i = 1; i <= num/2; i++){
           if (num % i == 0){
               sum += i;
           }
        }
        System.out.println("Tổng các ước của " + num + " là: " + sum);
    }
}
