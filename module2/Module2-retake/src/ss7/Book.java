package ss7;

public class Book implements IBook{
    private String name;
    private String publisher;
    private int yearOfPublic;

    public Book(){}

    public Book(String name, String publisher, int yearOfPublic) {
        this.name = name;
        this.publisher = publisher;
        this.yearOfPublic = yearOfPublic;
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

    public int getYearOfPublic() {
        return yearOfPublic;
    }

    public void setYearOfPublic(int yearOfPublic) {
        this.yearOfPublic = yearOfPublic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublic=" + yearOfPublic +
                '}';
    }
}
