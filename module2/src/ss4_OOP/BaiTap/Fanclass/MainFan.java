package ss4_OOP.BaiTap.Fanclass;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(Fan.FAST,true,10,"yellow");
        Fan fan2 = new Fan(Fan.MEDIUM, false,5, "blue");

        System.out.println("Quạt 1: " + fan1);
        System.out.println("Quạt 2: " + fan2);
    }
}
