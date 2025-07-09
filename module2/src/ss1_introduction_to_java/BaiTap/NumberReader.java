package ss1_introduction_to_java.BaiTap;

import java.util.Scanner;

public class NumberReader {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    System.out.print("Enter a number (0-999): ");
    int number = scanner.nextInt();

    if (number < 0 || number > 999) {
      System.out.println("out of ability");
      return;
    }

    String[] ones = {
      "zero", "one", "two", "three", "four",
      "five", "six", "seven", "eight", "nine"
    };
    String[] teens = {
      "ten", "eleven", "twelve", "thirteen", "fourteen",
      "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    String[] tens = {
      "", "", "twenty", "thirty", "forty",
      "fifty", "sixty", "seventy", "eighty", "ninety"
    };


    if (number >= 100) {
      int hundreds = number / 100;
      System.out.print(ones[hundreds] + " hundred");
      number = number % 100;
      if (number != 0) {
        System.out.print(" and ");
      } else {
        System.out.println();
        return;
      }
    }

    if (number < 10) {
      System.out.println(ones[number]);
    }

    else if (number < 20) {
      System.out.println(teens[number - 10]);
    }

    else {
      int tenPart = number / 10;
      int onePart = number % 10;

      System.out.print(tens[tenPart]);
      if (onePart != 0) {
        System.out.print(" " + ones[onePart]);
      }
      System.out.println();
    }

    scanner.close();
  }
}
