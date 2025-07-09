package ss18_string_and_regex.BaiTap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static boolean isValidNumber(String phone) {
        String regex = "^\\(84\\)-\\(0\\d{9}\\)$";
        return Pattern.matches(regex, phone);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập SĐT: ");
            String number = scanner.nextLine();
            if (!isValidNumber(number)) {
                System.out.println("SĐT không hợp lệ");
            } else {
                System.out.println(number + " " + "là SĐT hợp lệ");
            }
        }
    }
}
