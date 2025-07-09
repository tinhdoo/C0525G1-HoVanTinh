package ss1_introduction_to_java.BaiTap;
import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
  public static void main(String[] args) {
    double VND;
    double USD;
    final double rate = 26000;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số tiền (USD): ");


    if (scanner.hasNextInt()) {
      USD = scanner.nextDouble();
      if (USD > 0 && USD < 1000000000) {
        VND = USD * rate;
        System.out.println(VND + " VNĐ");
      }else {
        System.out.println("Số tiền phải từ 0 đến 1000000000");
      }
    }else {
      System.out.println("Bạn phải nhập số!");
    }
  }
}
