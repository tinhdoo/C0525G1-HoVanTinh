package ss7;

public class Book implements IBook{
    private String name;
    private String publisher;
    private int yearOfPublish;

    public Book(){}

    public Book(String name, String publisher, int yearOfPublish) {
        this.name = name;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
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
