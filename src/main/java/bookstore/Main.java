package bookstore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        showMenu();
        getData();
    }

    private static void readBook(String plik1) throws IOException {
        File file = new File(plik1);
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

        for (String line : list) {
            String[] split = line.split(";");
            Book book = new Book(Integer.parseInt(split[0]), split[1],
                    Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], null, null);
            books.add(book);
        }
        System.out.println(books);
        list.toString();
    }

    private static void readAuthor(String plik2) throws IOException {
        File file = new File(plik2);
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
        list.toString();
    }

    private static void readCategory(String plik3) throws IOException {
        File file = new File(plik3);
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
    }

    private static void getData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcję z Menu");
        int liczba = scanner.nextInt();

        while (liczba != 4) {
            if (liczba == 1) {
                readBook("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\books.csv");
                showMenu();
            }
            if (liczba == 2) {
                readAuthor("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\authors.csv");
                showMenu();
            }
            if (liczba == 3) {
                readCategory("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\categories.csv");
                showMenu();
            }
            liczba = scanner.nextInt();
        }
    }

    private static void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Wyświetl autorów");
        System.out.println("3. Wyświetl kategorie");
        System.out.println("4. Wyjdź z programu");
    }
}