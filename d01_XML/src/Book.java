import java.math.BigDecimal;

public class Book {

    private String sn;
    private String author;
    private String name;
    private BigDecimal price;

    public Book() {
    }

    public Book(String sn, String author, String name, BigDecimal price) {
        this.sn = sn;
        this.author = author;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
