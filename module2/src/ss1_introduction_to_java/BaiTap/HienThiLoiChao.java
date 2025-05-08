package ss1_introduction_to_java.BaiTap;

import java.util.Scanner;

public class HienThiLoiChao {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name;
    System.out.println("Enter your name: ");
    name = scanner.nextLine();


    System.out.println("Hello"+ " " + name);
  }
}
