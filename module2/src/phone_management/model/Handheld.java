package phone_management.model;

public class Handheld extends Phone{
    private int time;
    private boolean scope;

    public Handheld(int id, String name, double price, int quantity, String manufacturer, int time, boolean scope) {
        super(id, name, price, quantity, manufacturer);
        this.time = time;
        this.scope = scope;
    }

    public Handheld(int time, boolean scope) {
        this.time = time;
        this.scope = scope;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isScope() {
        return scope;
    }

    public void setScope(boolean scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Handheld{" +
                "time=" + time +
                ", scope=" + scope +
                '}';
    }
}
