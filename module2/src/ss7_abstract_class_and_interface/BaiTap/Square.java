package ss7_abstract_class_and_interface.BaiTap;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void resize(double percent) {
        double newSide = getSide() * (1 + percent / 100);
        setSide(newSide);
    }

    @Override
    public double getArea() {
        return getSide() * getSide();
    }

    @Override
    public double getPerimeter() {
        return 4 * getSide();
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() +
                ", area=" + getArea() +
                ", which is a subclass of " + super.toString();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

}
