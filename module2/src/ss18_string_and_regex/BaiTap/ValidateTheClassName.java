package ss18_string_and_regex.BaiTap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTheClassName {
    public static boolean isValidName(String className) {
        String regex = "^[CAP]\\d{4}[GHIK]$";
        return Pattern.matches(regex, className);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tên lớp: ");
            String name = scanner.nextLine();
            if (!isValidName(name)) {
                System.out.println("Tên lớp không hợp lệ");
            } else {
                System.out.println(name + " " + "là tên lóp hợp lệ");
            }
        }
    }
}
