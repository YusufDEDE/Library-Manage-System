package LibrarySystem;

public class Book extends Source{

    public  Book(){

    }
    public Book(int bookId, String author, String name, double price, Boolean status) {
        super(bookId, author, name, price, status);
    }
}