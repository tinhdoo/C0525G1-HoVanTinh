package ss15_IO_text_file.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader("D:\\Codegym\\module2\\src\\ss15_IO_text_file\\ReadFile\\Countries.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("lỗi đọc ghi");
        } catch (RuntimeException e) {
            System.out.println("Lỗi thời gian chạy");
        }
    }
}
