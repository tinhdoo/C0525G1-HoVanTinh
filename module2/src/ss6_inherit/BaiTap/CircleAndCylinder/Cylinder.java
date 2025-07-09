package ss6_inherit.BaiTap.CircleAndCylinder;

import ss6_inherit.BaiTap.CircleAndCylinder.Circle;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double radius,double height){
        super(radius);
        this.height=height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    public double getVolume(){
        return getArea()* height;}
    @Override
    public String toString() {
        return "Cylinder" +
                String.format(" " + "radius = %.1f ",radius) +
                String.format(", color= %s ",  color)  +
                String.format(", Volume = %.1f ",getVolume());
    }
}
