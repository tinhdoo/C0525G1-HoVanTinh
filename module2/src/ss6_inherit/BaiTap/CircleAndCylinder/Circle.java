package ss6_inherit.BaiTap.CircleAndCylinder;

public class Circle {
    public double radius;
    public String color;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Circle" +
                String.format(" " + "radius = %.1f ",radius) +
                String.format(", color= %s ",  color)  +
                String.format(", Area = %.1f ",getArea());
    }
}
