import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        showMenu();
        getData();
        readFromFile("C:\\Users\\Tomasz.Dorotka-VAIO\\IdeaProjects\\Bookstore\\books.csv");

//        Book book = new Book("tytul", 888,19912);
//        System.out.println(book.year);
    }

    public static String readFromFile(String plik) throws IOException {
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
        for (String line : list) {
            String[] split = line.split(";");
            Book book = new Book(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            books.add(book);

        }
        System.out.println(books);
        return list.toString();

    }

    private static void getData() {             // metoda na pobranie wartości od użytkownika
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcję 1 lub 2 z Menu");
        int liczba = scanner.nextInt();

        while (liczba != 2) {
            if (liczba == 1) {
                System.out.println("Wyświetlam dane, dużo dużo danych");
                showMenu();
            }
            liczba = scanner.nextInt();
        }
    }

    private static void showMenu() {        // metoda do wyświetlania MENU
        System.out.println("Menu");
        System.out.println("1. Wyświetl dane");
        System.out.println("2. Wyjdź z programu");
    }
}
