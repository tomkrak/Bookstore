import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Category> categories;

    public static void main(String[] args) throws IOException {
        showMenu();
        getData();

//        Book book = new Book("tytul", 888,19912); // przykłąd tworzenia obiektu w Javie na podstawie konstruktora
//        System.out.println(book.year);
    }

    public static String readBook(String plik) throws IOException {     // metoda odczytu z pliku dla ksiązek
        File file = new File(plik);
        List<String> list = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        List<Book> books = new ArrayList<>();
        List<Category> categories = readCategory("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\categories.csv");

        for (String line : list) {
            String[] split = line.split(";");
            String[] idAuthorSplit = split[5].split(",");
            int categoryId = Integer.parseInt(split[6]);
//            int cate = categories.get(3);
            Book book = new Book(Integer.parseInt(split[0]), split[1],
                    Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], null, null);
            books.add(book);

        }
        System.out.println(books);
        return list.toString();

    }

    public static String readAuthor(String plik) throws IOException {
        File file = new File(plik);
        List<String> list = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        List<Author> authors = new ArrayList<>();
        for (String line : list) {
            String[] split = line.split(";");
            Author author = new Author(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            authors.add(author);

        }
        System.out.println(authors);
        return list.toString();

    }

    public static List<Category> readCategory(String plik) throws IOException {
        File file = new File(plik);
        List<String> list = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        List<Category> categories = new ArrayList<>();
        for (String line : list) {
            String[] split = line.split(";");
            Category category = new Category(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            categories.add(category);

        }
        System.out.println(categories);
        return categories;

    }

    private static void getData() throws IOException {                          // metoda na pobranie wartości od użytkownika
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcję z Menu");
        int liczba = scanner.nextInt();

        while (liczba != 4) {
            if (liczba == 1) {
                readBook("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\books.csv");     // wywołanie metody
                showMenu();
            }
            if (liczba == 2) {
                readAuthor("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\authors.csv");
                showMenu();
            }
            if (liczba == 3) {
                List<Category> categories = readCategory("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\categories.csv");
                showMenu();
            }

            liczba = scanner.nextInt();
        }
    }

    private static void showMenu() {                // metoda do wyświetlania MENU
        System.out.println("Menu");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Wyświetl autorów");
        System.out.println("3. Wyświetl kategorie");
        System.out.println("4. Wyjdź z programu");
    }
}
