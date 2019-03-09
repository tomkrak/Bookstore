package bookstore;

import java.util.List;

class Book {
    private final int id;
    private final String title;
    private final long isbn;
    private final int year;
    private final String cover;
    private final List<Author> idAuthor;
    private final Category idCategory;

    public Book(int id, String title, long isbn, int year, String cover, List<Author> idAuthor, Category idCategory) {   // konstruktor
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
        return "bookstore.Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                ", cover='" + cover + '\'' +
                ", idAuthor=" + idAuthor +
                ", idCategory=" + idCategory +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getCover() {
        return cover;
    }

    public List<Author> getIdAuthor() {
        return idAuthor;
    }

    public Category getIdCategory() {
        return idCategory;
    }
}

