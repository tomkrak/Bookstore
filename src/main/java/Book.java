import java.io.*;
import java.util.List;

public class Book {
    int id;
    String title;
    int isbn;
    int year;
    String cover;
    List<Author> idAuthor;
    Category idCategory;

    public Book(int id, String title, int isbn, int year, String cover, List<Author> idAuthor, Category idCategory) {   // konstruktor
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.cover = cover;
        this.idAuthor = idAuthor;
        this.idCategory = idCategory;
    }

    @Override                  // metoda toString powoduje, że nie wyświetla śmieci jak wyświetla obiekt (np.@234234jdsjlskdfj)
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                ", cover='" + cover + '\'' +
                ", idAuthor=" + idAuthor +
                ", idCategory=" + idCategory +
                '}';
    }
}

