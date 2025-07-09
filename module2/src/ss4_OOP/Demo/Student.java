package ss4_OOP.Demo;

import java.time.LocalDate;

public class Student {

    long code;

    String name;

    String phoneNumber;

    LocalDate dob;

    String address;

    Boolean gender;

    public Student() {
        this(1, "HaiTT", "1", LocalDate.now(), "QN", true);
    }



    public Student(long code, String name, String phoneNumber, LocalDate dob, String address, Boolean gender) {

        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }

    public String toString() {
        String result ;
        if(this.gender == null) {
            result = "Other";
        } else if(this.gender) {
            result = "Female";
        } else {
            result = "Male";
        }
        return String.format("| %-10d | %-20s | %-15s | %-12s | %-20s | %-10s |",
                code,
                name,
                phoneNumber,
                dob.toString(), // hoặc định dạng dd/MM/yyyy nếu muốn
                address,
                result
        );
    }


}
