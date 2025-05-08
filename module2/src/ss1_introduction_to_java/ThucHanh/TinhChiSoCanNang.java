package ss1_introduction_to_java.ThucHanh;

import java.util.Scanner;

public class TinhChiSoCanNang {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    float weight;
    float height;
    double BMI;
    System.out.println("Enter weight: ");
    weight = scanner.nextFloat();

    System.out.println("Enter height: ");
    height = scanner.nextFloat();

    BMI = weight / Math.pow(height,2);
    if (BMI < 18.5){
      System.out.println("Underweight");
    } else if (BMI < 25.0) {
      System.out.println("Normal");
    } else if (BMI < 30.0){
      System.out.println("Overweight");
    } else {
      System.out.println("Obese");
    }

  }
}
