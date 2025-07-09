package ss7_abstract_class_and_interface.BaiTap;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(2.5);
        shapes[1] = new Rectangle(4.0, 5.0);
        shapes[2] = new Square(3.0);

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea());

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println("----------------------");
        }
    }
}
