package Book;

public class Book {
    protected String bookCode;
    protected String name;
    protected double price;
    protected String author;
    static double totalPrice;

    public Book() {
    }

    public Book(String bookCode, String name, double price, String author) {
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
        totalPrice += price;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        totalPrice += price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookCode='" + bookCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }



}
