package ss5_access_modifier.BaiTap;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name = "john";
        this.classes = "C02";
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Tên: " + name + " --- " + "Lớp: " + classes);
    }
}
