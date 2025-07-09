package case_study.model;

public class Employee {
    private int id;
    private String name;
    private String role;
    private boolean gender;
    private int age;

    private String phone;
    private double salary;

    public Employee(int id, String name, String role, boolean gender, int age, String phone, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
    }


    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender ? "Nam" : "Nữ";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-15s | %-5s | %-4d | %-12s | %10.0f |",
                id, name, role, getGender(), age, phone, salary);
    }

}
