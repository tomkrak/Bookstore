package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        authors.add(new Author(authors.get(7).getId() + 1, authorName, authorAge));     // TODO
        System.out.println("Nowy autor został dodany");
    }

    private static void addNewCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nową kategorię");
        String categoryName = scanner.nextLine();
        categories.add(new Category(categories.get(2).getId() + 1, categoryName, 1));       // TODO
        System.out.println("Nowa kategoria została dodana");
    }

    private static void editCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz, którą kategorię chcesz edytować:");
        String categoryToFulfit = "";
        for (Category category : categories) {
            categoryToFulfit += category.getId() + ". " + category.getCategoryName() + "\n";
        }
        System.out.println(categoryToFulfit);
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

    private static void showDesignPatterns() {
        List<Book> designPatterns = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().getCategoryName().equals("Wzorce projektowe")) {
                designPatterns.add(book);
            }
        }
        System.out.println(designPatterns);
    }

    private static List<Book> showAllBooksByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz autora:");
        String authorToFulfit = "";
        for (Author author : authors) {
            authorToFulfit += author.getId() + ". " + author.getName() + "\n";
        }
        System.out.println(authorToFulfit);
        int authorNumber = Integer.parseInt(scanner.nextLine());

        List<Book> allBooksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (authorNumber == book.getAuthor().getId()) {
                allBooksByAuthor.add(book);
            }
        }
        System.out.println(allBooksByAuthor);
        return allBooksByAuthor;
    }

    private static void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WYBIERZ OPCJĘ Z MENU:");
        int userNumber = scanner.nextInt();
        switch (userNumber) {
            case 1:
                System.out.println(books);
                System.out.println();
                showMenu();
                break;
            case 2:
                System.out.println(authors);
                System.out.println();
                showMenu();
                break;
            case 3:
                System.out.println(categories);
                System.out.println();
                showMenu();
                break;
            case 4:
                addNewAuthor();
                System.out.println();
                showMenu();
                break;
            case 5:
                addNewCategory();
                System.out.println();
                showMenu();
                break;
            case 6:
                SaveToFile.saveListAuthors();
                System.out.println();
                showMenu();
                break;
            case 7:
                System.out.println(BookFunctions.getBooksStartWithCPublishedAfter2007(books));
                System.out.println();
                showMenu();
                break;
            case 8:
                editCategory();
                System.out.println();
                showMenu();
                break;
            case 9:
                showDesignPatterns();
                System.out.println();
                showMenu();
                break;
            case 10:
                showAllBooksByAuthor();
                System.out.println();
                showMenu();
                break;
            case 11:
                System.out.println("Wychodzę z programu");
                break;
            default:
                showMenu();
                break;
        }
        getData();
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