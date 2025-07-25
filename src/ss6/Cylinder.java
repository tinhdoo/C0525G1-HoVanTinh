package ss6;

public class Cylinder extends Circle{
    private double height;
    public Cylinder(){
    }           //overloading
    // thành phần không được kế thừa là constructor circle
    public Cylinder(double height) {     //overload
        this.height = height;
    }          //overloading

    public Cylinder(double radius, String color, double height) {
        super(radius, color);   // radius và color không được kế thừa mà gọi constructor của lớp cha
        this.height = height;
    }          //overloading

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea() * this.height;   //getArea được kế thừa
    }

    @Override    //override
    public String toString() {
        return "A Cylinder with height is "
                + this.height
                + " , which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(23, "yellow", 40.0);
        System.out.println(cylinder);
    }
}
