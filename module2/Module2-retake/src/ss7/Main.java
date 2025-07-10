package ss7;

public class Main {
    public static void main(String[] args) {
        IBook[] books = new IBook[5];

        books[0] = new NaturalBook("Toán", "NXB Giáo Dục", 2021, 1000);
        books[1] = new SocialBook("Văn Học", "NXB Kim Đồng", 2022, "Nguyễn Nhật Ánh");
        books[2] = new NaturalBook("Hóa", "NXB Giáo Dục", 2020, 800);
        books[3] = new SocialBook("Lịch Sử", "NXB Trẻ", 2023, "Phan Anh");
        books[4] = new NaturalBook("Sinh Học", "NXB Giáo Dục", 2019, 600);

        for (IBook book : books) {
            book.display();
        }
    }
}
