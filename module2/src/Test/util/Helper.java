package Test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {
    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^(0|\\+84)[0-9]{9}$");
    }
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

/*
    System.out.print("Email: ");
    String email;
    while (true) {
        email = scanner.nextLine();
        if (isValidEmail(email)) break;
        System.out.print("❌ Email sai định dạng. Nhập lại: ");
    }
*/

}
