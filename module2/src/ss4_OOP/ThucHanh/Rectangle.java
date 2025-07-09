package ss4_OOP.ThucHanh;

public class Rectangle {
    int height;
    int width;

    public Rectangle() {

    }
    public Rectangle(int height,  int width){
        this.height = height;
        this.width = width;
    }
    public int getArea(){
        return width * height;
    }
    public int getPerimeter(){
        return 2 * (width + height);
    }
    public String display(){
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}

