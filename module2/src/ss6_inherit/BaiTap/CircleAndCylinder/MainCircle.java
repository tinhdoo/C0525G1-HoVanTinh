package ss6_inherit.BaiTap.CircleAndCylinder;

import ss6_inherit.BaiTap.CircleAndCylinder.Circle;
import ss6_inherit.BaiTap.CircleAndCylinder.Cylinder;

public class MainCircle{
    public static void main(String[] args) {
        Circle circle = new Circle(5.5);
        Cylinder cylinder = new Cylinder(4.5,4);
        circle.setColor("blue");
        System.out.println(circle.toString());
        System.out.println("----------------------------------------------------");
        System.out.println(cylinder.toString());

    }
}
