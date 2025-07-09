package ss2_loops_in_java.BaiTap;

import java.util.Scanner;

public class ShowTypes {
  public static void main(String[] args) {
    int choice = -1;
    Scanner input = new Scanner(System.in);

    while (choice != 4) {
      System.out.println("Menu");
      System.out.println("1.Print the rectangle");
      System.out.println("2.Print the square triangle");
      System.out.println("3.Print isosceles triangle");
      System.out.println("4.Exit");
      System.out.println("Enter your choice: ");
      choice = input.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Print the rectangle");
          System.out.println("* * * * * *");
          System.out.println("* * * * * *");
          System.out.println("* * * * * *");
          break;
        case 2:
          System.out.println("Print the square triangle");
          for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
              System.out.print("* ");
            }
            System.out.println();
          }
          System.out.println();
          for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
              System.out.print("* ");
            }
            System.out.println();
          }

          System.out.println();
          break;

        case 3:
          System.out.println("Print isosceles triangle");
          for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
              System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
              System.out.print("* ");
            }
            System.out.println();
          }
          break;

        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("No choice!");
      }
    }
  }
}
