package bookstore;

class Book {
    private final int id;
    private final String title;
    private final long isbn;
    private final int year;
    private final String cover;
    private final Author author;
    private final Category category;

    public Book(int id, String title, long isbn, int year, String cover, Author author, Category category) {    // konstruktor
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.cover = cover;
        this.author = author;
        this.category = category;
    }

    @Override
    // metoda toString powoduje, że nie wyświetla śmieci jak wyświetla obiekt (np.@234234jdsjlskdfj)
    public String toString() {
        return "bookstore.Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                ", cover='" + cover + '\'' +
                ", author=" + author +
                ", category=" + category +
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

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}

