package ss7_abstract_class_and_interface.BaiTap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Square(6);

        Random random = new Random();

        for (Resizeable shape : shapes) {
            double before = 0;
            if (shape instanceof Circle) {
                before = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                before = ((Rectangle) shape).getArea();
            } else if (shape instanceof Square) {
                before = ((Square) shape).getArea();
            }

            double percent = random.nextInt(100) + 1; // từ 1 đến 100
            System.out.printf("Before resize: %.2f\n", before);
            System.out.printf("Resizing by: %.2f%%\n", percent);

            shape.resize(percent);

            double after = 0;
            if (shape instanceof Circle) {
                after = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                after = ((Rectangle) shape).getArea();
            } else if (shape instanceof Square) {
                after = ((Square) shape).getArea();
            }
            System.out.printf("After resize: %.2f\n\n", after);

        }

    }

}
