package ss7;

public class Book implements IBook{
    protected String name;
    protected String publisher;
    protected int yearOfPublish;

    public Book(){}

    public Book(String name, String publisher, int yearOfPublish) {
        this.name = name;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
    }

    public Book(String name, String publisher) {
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublic=" + yearOfPublish +
                '}';
    }

    @Override
    public void display() {

    }
}
