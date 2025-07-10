package ss7;

public class NaturalBook extends Book{
    public int quantity;

    public NaturalBook(int quantity) {
        this.quantity = quantity;
    }

    public NaturalBook(String name, String publisher, int yearOfPublish, int quantity) {
        super(name, publisher, yearOfPublish);
        this.quantity = quantity;
    }
    public void display() {
        System.out.println("Natural Book: " + name + ", " + publisher + ", " + yearOfPublish + ", Quantity: " + quantity);
    }
}
