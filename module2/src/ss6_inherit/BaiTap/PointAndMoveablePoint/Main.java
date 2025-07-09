package ss6_inherit.BaiTap.PointAndMoveablePoint;

public class Main {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(3,5,5,2);
        System.out.println(moveablePoint.toString());
        System.out.println(moveablePoint.move());

        Point point = new Point(3,4);
        System.out.println(point.toString());

    }
}
