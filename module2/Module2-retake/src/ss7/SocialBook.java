package ss7;

public class SocialBook extends Book{
    public String author;

    public SocialBook(String author) {
        this.author = author;
    }

    public SocialBook(String name, String publisher, int yearOfPublic, String author) {
        super(name, publisher, yearOfPublic);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
