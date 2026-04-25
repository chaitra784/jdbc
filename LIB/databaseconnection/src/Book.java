public class Book {

    int book_id;
    String title;
    String author;
    String genre;
    double price;
    int available_copies;

    public Book(String title, String author, String genre, double price, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available_copies = copies;
    }
}