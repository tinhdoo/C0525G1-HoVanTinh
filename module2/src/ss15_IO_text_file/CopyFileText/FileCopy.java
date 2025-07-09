package ss15_IO_text_file.CopyFileText;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.println("Nhập đường dẫn tệp đích: ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại. Bạn có muốn ghi đè? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Hủy sao chép.");
                return;
            }
        }

        try (
                FileInputStream inputStream = new FileInputStream(sourceFile);
                FileOutputStream outputStream = new FileOutputStream(targetFile)
        ) {
            int byteRead;
            int count = 0;

            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
                count++;
            }

            System.out.println("Sao chép thành công! Tổng số byte đã sao chép: " + count);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi trong quá trình sao chép: " + e.getMessage());
        }
    }
}

