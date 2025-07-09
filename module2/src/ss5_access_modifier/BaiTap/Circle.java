package ss5_access_modifier.BaiTap;

public class Circle {
    private final double radius;
    private final String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
    public String getColor() {
        return color;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}


