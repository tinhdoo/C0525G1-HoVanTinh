package ss7;

public class NaturalBook extends Book implements IBook{
    private int quantity;

    public NaturalBook(int quantity) {
        this.quantity = quantity;
    }

    public NaturalBook(String name, String publisher, int yearOfPublish, int quantity) {
        super(name, publisher, yearOfPublish);
        this.quantity = quantity;
    }
    public void display() {
        System.out.println("Natural Book: " + getName() + ", " + getPublisher() + ", " + getYearOfPublish() + ", Quantity: " + quantity);
    }
}
