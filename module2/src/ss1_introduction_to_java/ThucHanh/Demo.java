package ss1_introduction_to_java.ThucHanh;

import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter a number: ");

    int number = reader.nextInt();

    System.out.println(3 + 4 * 4);

    System.out.println("You entered: " + number);
  }
}
