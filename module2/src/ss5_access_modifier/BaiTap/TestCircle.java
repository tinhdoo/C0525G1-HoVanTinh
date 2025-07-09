package ss5_access_modifier.BaiTap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        double radius = circle1.getRadius();
        double area = circle1.getArea();
        String color = circle1.getColor();
        System.out.println("Bán kính: " + radius);
        System.out.println("Diện tích: " + area);
        System.out.println("Màu: " + color);

    }
}
