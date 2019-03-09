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
        readBook("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\books.csv");
        readAuthor("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\authors.csv");
        readCategory("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\categories.csv");
        showMenu();
        getData();
    }

    private static void readBook(String fileBooks) throws IOException {
        File file = new File(fileBooks);
        List<String> forAdding = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                forAdding.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        for (String line : forAdding) {
            String[] split = line.split(";");
            Book book = new Book(Integer.parseInt(split[0]), split[1],
                    Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], null, null);
            books.add(book);
        }
    }

    private static void readAuthor(String fileAuthors) throws IOException {
        File file = new File(fileAuthors);
        List<String> forAdding = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                forAdding.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        for (String line : forAdding) {
            String[] split = line.split(";");
            Author author = new Author(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            authors.add(author);
        }
    }

    private static void readCategory(String fileCategories) throws IOException {
        File file = new File(fileCategories);
        List<String> forAdding = new ArrayList<>();
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                forAdding.add(reader.readLine());
            }
            reader.close();
            isr.close();
            is.close();
        }
        for (String line : forAdding) {
            String[] split = line.split(";");
            Category category = new Category(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            categories.add(category);
        }
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
        System.out.println("Wybierz, którą kategorię chcesz edytować\n1. Java\n2. Wzorce projektowe\n3. Techniki programowania");
        int number = scanner.nextInt();
        while (number != 3) {
            if (number == 1) {
                System.out.println(books);
            } else if (number == 2) {
                System.out.println(authors);

                String categoryName = scanner.nextLine();
            }
        }
    }
        private static void getData () throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("WYBIERZ OPCJĘ Z MENU:");
            int liczba = scanner.nextInt();
            while (liczba != 9) {
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
                }
                liczba = scanner.nextInt();
            }
        }

        private static void showMenu () {
            System.out.println("Menu");
            System.out.println("1. Wyświetl książki");
            System.out.println("2. Wyświetl autorów");
            System.out.println("3. Wyświetl kategorie");
            System.out.println("4. Dodaj nowego autora");
            System.out.println("5. Dodaj nową kategorię");
            System.out.println("6. Zapisz listę autorów do pliku csv");
            System.out.println("7. Zwróć książki, których tytuł zaczyna się od litery “C” wydane po 2007 roku");
            System.out.println("8. Edytuj nazwę kategorii");
            System.out.println("9. Wyjdź z programu");

        }
    }