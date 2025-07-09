package ss6_inherit.BaiTap.Point2DAnd3D;

public class Point3D extends Point2D {
    public float z = 0.0f;
    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{getX(),getY(), z};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                " x=" + getX() +
                ", y=" + getY() +
                ", z=" + z +
                '}';
    }
}
