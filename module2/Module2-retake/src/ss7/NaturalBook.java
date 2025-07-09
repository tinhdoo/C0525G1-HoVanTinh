package ss7;

public class NaturalBook extends Book{
    public int quantity;

    public NaturalBook(int quantity) {
        this.quantity = quantity;
    }

    public NaturalBook(String name, String publisher, int yearOfPublic, int quantity) {
        super(name, publisher, yearOfPublic);
        this.quantity = quantity;
    }
}
