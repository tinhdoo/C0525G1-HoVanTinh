package ss4_OOP.BaiTap.Fanclass;

public class Fan {
    //khai báo hằng số
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    int speed = SLOW;
    boolean status = false;
    double radius = 5;
    String color = "blue";


    public Fan(int speed, boolean status, double radius, String color) {
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String result;
        if (status) {
            result = "Bán kính: " + getRadius() + " --- " + " Màu sắc: "+ getColor() + " --- " +"Trạng thái: " + "Quạt đang tắt";
        } else {
            result = "Tốc độ: " + getSpeed() + " --- " + "Bán kính: " + getRadius() + " --- " + "Màu sắc: " + getColor() + " --- " + "Trạng thái: " + "Quạt đang bật";

        }
        return result;
    }
}


