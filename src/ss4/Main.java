package ss4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(2000, 12, 12);
        Doctor doctor = new Doctor("Tinh", birthday, "Da Nang","hotinh13102@gmail.com", "0905574378","Doctor");
        System.out.println(doctor);

    }
}
