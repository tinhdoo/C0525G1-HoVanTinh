package common;

import java.util.Scanner;

public class InputExceptions extends Exception {
    public static int inputInterger() {
        int choose;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên");
                continue;
            } catch (Exception e) {
                System.out.println("Lỗi không xác định!");
                continue;
            }
            return choose;
        }
    }

}


