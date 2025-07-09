package ss4_OOP.BaiTap;

import java.util.Scanner;


public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }


    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0)
            return (-b + Math.sqrt(delta)) / (2 * a);
        else
            return Double.NaN;
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0)
            return (-b - Math.sqrt(delta)) / (2 * a);
        else
            return Double.NaN;
    }

}
