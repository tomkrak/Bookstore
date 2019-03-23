package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static bookstore.Main.authors;

public class SaveToFile {

    public static void saveListAuthors() {
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
            System.out.println("FileNotFoundException: the given file object does not denote an existing, writable regular file");
        }
    }
}