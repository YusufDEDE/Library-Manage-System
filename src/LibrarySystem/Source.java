package LibrarySystem;

import java.util.LinkedList;

public abstract class Source {
     private int bookId;
     private String author;
     private String name;
     private double price;
     private boolean status;

    private static LinkedList<Book> book;

    public Source() {
    }

    public Source(int bookId, String author, String name, double price, boolean status) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Source bookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public Source author(String author) {
        this.author = author;
        return this;
    }

    public Source name(String name) {
        this.name = name;
        return this;
    }

    public Source price(double price) {
        this.price = price;
        return this;
    }

    public Source status(boolean status) {
        this.status = status;
        return this;
    }

    public void addBook(int bookId, String author, String name, double price, boolean status){
        book = new LinkedList<Book>();
        book.add(new Book(bookId,author,name,price,status));

    }

    public String listBook(){

        return "SSS";

    }

    @Override
    public String toString() {
        return
             getBookId() + "," +
             getAuthor() + "," +
             getName() + "," +
             getPrice() + "," +
             isStatus();
    }



    public void displayBookDetails(){
        // Todo display print
        System.out.println("Todo display book details");
    }
    public void updateStatus(){
        // Todo update
        System.out.println("Todo update status");
    }

       
}