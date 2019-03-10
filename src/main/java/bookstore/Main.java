package bookstore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static List<Book> books = new ArrayList<>();
    static List<Author> authors = new ArrayList<>();
    static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readAuthor("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\authors.csv");
        readFromFile.readCategory("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\categories.csv");
        readFromFile.readBook("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\books.csv");
        showMenu();
        getData();
    }

    private static void addNewAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię i nazwisko autora");
        String authorName = scanner.nextLine();
        System.out.println("Podaj wiek autora");
        int authorAge = scanner.nextInt();
        authors.add(new Author(authors.get(7).getId() + 1, authorName, authorAge));
        System.out.println("Nowy autor został dodany");
    }

    private static void addNewCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nową kategorię");
        String categoryName = scanner.nextLine();
        categories.add(new Category(1, categoryName, 1));
        System.out.println("Nowa kategoria została dodana");
    }

    private static void saveListAuthors() {
        try (PrintWriter writer = new PrintWriter(new File("authorslist.csv"))) {

            for (Author author : authors) {
                StringBuilder build = new StringBuilder();
                build.append(author.getId());
                build.append(';');
                build.append(author.getName());
                build.append(';');
                build.append(author.getAge());
                build.append('\n');
                writer.write(build.toString());
            }
            System.out.println("Plik *autorslist.csv* został zapisany");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz, którą kategorię chcesz edytować:");
        String g = "";
        for (Category category : categories) {
            g = g + category.getId() + ". " + category.getCategoryName() + "\n";
        }
        System.out.println(g);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Podaj nową nazwę kategorii");
        String newName = scanner.nextLine();

        for (Category category : categories) {
            if (category.getId() == number) {
                category.setCategoryName(newName);
            }
        }
        System.out.println(categories);
    }

    private static List<Book> showDesignPatterns() {
        List<Book> designPatterns = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().getCategoryName().equals("Wzorce projektowe")) {
                designPatterns.add(book);
            }
        }
        System.out.println(designPatterns);
        return designPatterns;
    }

    private static List<Book> showAllBooksByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz autora:");
        String h = "";
        for (Author author : authors) {
            h = h + author.getId() + ". " + author.getName() + "\n";
        }
        System.out.println(h);
        int authorNumber = Integer.parseInt(scanner.nextLine());

        List<Book> allBooksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if(authorNumber == book.getAuthor().getId()) {
                book.getTitle();
                allBooksByAuthor.add(book);
            }
        }
        System.out.println(allBooksByAuthor);
        return allBooksByAuthor;
    }

    private static void getData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WYBIERZ OPCJĘ Z MENU:");
        int liczba = scanner.nextInt();
        while (liczba != 11) {
            if (liczba == 1) {
                System.out.println(books);
                showMenu();
            } else if (liczba == 2) {
                System.out.println(authors);
                showMenu();
            } else if (liczba == 3) {
                System.out.println(categories);
                showMenu();
            } else if (liczba == 4) {
                addNewAuthor();
                showMenu();
            } else if (liczba == 5) {
                addNewCategory();
                showMenu();
            } else if (liczba == 6) {
                saveListAuthors();
                showMenu();
            } else if (liczba == 7) {
                System.out.println(BookFunctions.getBooksStartWithCPublishedAfter2007(books));
                showMenu();
            } else if (liczba == 8) {
                editCategory();
                showMenu();
            } else if (liczba == 9) {
                showDesignPatterns();
                showMenu();
            } else if (liczba == 10) {
                showAllBooksByAuthor();
                showMenu();
            }
            liczba = scanner.nextInt();
        }
    }

    private static void showMenu() {
        System.out.println("M-E-N-U");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Wyświetl autorów");
        System.out.println("3. Wyświetl kategorie");
        System.out.println("4. Dodaj nowego autora");
        System.out.println("5. Dodaj nową kategorię");
        System.out.println("6. Zapisz listę autorów do pliku csv");
        System.out.println("7. Zwróć książki, których tytuł zaczyna się od litery “C” wydane po 2007 roku");
        System.out.println("8. Edytuj nazwę kategorii");
        System.out.println("9. Wyświetl wszystkie książki z kategorii Wzorce projektowe");
        System.out.println("10. Wyświetl wszystkie książki wybranego autora");
        System.out.println("11. Wyjdź z programu");
    }
}