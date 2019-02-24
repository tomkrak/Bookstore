import java.io.*;

public class Book {
    String title;
    int isbn;
    int year;

    public Book(String title, int isbn, int year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book (" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                ')';
    }
}

