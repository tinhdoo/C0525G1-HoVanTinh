package ss12_search_algorithm.BaiTap.StudentManager.entity;

public class Person {
    private long code;
    private String name;
    private String address;

    public Person() {
    }

    public Person(long code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", name='" + name + '\'' +
                ", address='" + address;
    }
}
