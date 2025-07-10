package ss7;

public class SocialBook extends Book {
    public String author;

    public SocialBook(String author) {
        this.author = author;
    }

    public SocialBook(String name, String publisher, int yearOfPublish, String author) {
        super(name, publisher, yearOfPublish);
        this.author = author;
    }
    public void display() {
        System.out.println("Social Book: " + name + ", " + publisher + ", " + yearOfPublish + ", Author: " + author);
    }
}

