package ss6_inherit.ThucHanh;

import ss6_inherit.ThucHanh.Circle;

public class CircleTest extends Circle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
    }
}