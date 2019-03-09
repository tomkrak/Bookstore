package bookstore;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookFunctions {


    // 1. Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę
    public Book searchByIsbn(long isbn, List<Book> allBooks) {
        for (Book book : allBooks) {
            if (book.getIsbn() == 9780596150211L) {
                return book;
            }
        }
        return null;
    }

    // 1A.Stream. Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę
    public Book searchByIsbnStream(long isbn, List<Book> allBooks) {
        return allBooks.
                stream().
                filter(book -> book.getIsbn() == 9780596150211L).
                findFirst().
                orElse(null);
    }

    // 2. Zwróć dwie ostatnie książki
    public List<Book> getTwoLast(List<Book> allBooks) {
        return allBooks.subList(allBooks.size() - 2, allBooks.size());
    }

    // 2A.Stream. Zwróć dwie ostatnie książki
    public List<Book> getTwoLastStream(List<Book> allBooks) {
        return allBooks
                .stream()
                .skip(allBooks.size() - 2)
                .collect(Collectors.toList());
    }

    // 3. Zwróć najwcześniej wydana książkę                               //TODO
    public Book getEarliestPublished(List<Book> allBooks) {
        return null;
    }

    // 4. Zwróć najpóźniej wydana książkę                                 //TODO
    public Book getLastPublished(List<Book> allBooks) {
        return null;
    }

    // 5. Zwróć sumę lat wydania wszystkich książek
    public int sumAllYears(List<Book> allBooks) {
        int i = 0;
        for (Book book : allBooks) {
            i += book.getYear();
        }
        return i;
    }

    // 5A.Stream. Zwróć sumę lat wydania wszystkich książek
    public int sumAllYearsStream(List<Book> allBooks) {
        return allBooks.stream().mapToInt(book -> book.getYear()).sum();
    }

    // 6. Zwróć liczbę książek wydanych po 2007 roku
    public int getBooksPublishedAfter2007(List<Book> allBooks) {
        int i = 0;
        for (Book book : allBooks) {
            if (book.getYear() > 2007) {
                i += 1;
            }
        }
        return i;
    }

    // 6A.Stream. Zwróć liczbę książek wydanych po 2007 roku
    public int getBooksPublishedAfter2007Stream(List<Book> allBooks) {
        return (int) allBooks.stream().filter(book -> book.getYear() > 2007).count();
    }

    // 7. Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku
    public boolean areBooksPublishedAfter2000(List<Book> allBooks) {
        boolean b = true;
        for (Book book : allBooks) {
            if (book.getYear() <= 2000) {
                b = false;
            }
        }
        return b;
    }

    // 7A.Stream. Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku
    public boolean areBooksPublishedAfter2000Stream(List<Book> allBooks) {
        long count = allBooks.stream().filter(book -> book.getYear() <= 2000).count();
        boolean result = allBooks.size() != count;
        return result;
    }

    // 8. Zwróć średni rok wydania książki w naszym katalogu
    public int getYearMediana(List<Book> allBooks) {
        int i = 0;
        for (Book book : allBooks) {
            i += book.getYear();
        }
        return i / allBooks.size();
    }

    // 8A.Stream. Zwróć średni rok wydania książki w naszym katalogu
    public int getYearMedianaStream(List<Book> allBooks) {
        int i = allBooks.stream().mapToInt(book -> book.getYear()).sum();
        return i / allBooks.size();
    }

    // 9. Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed 2003 rokiem
    public boolean isAnyPublishedBefore2003(List<Book> allBooks) {
        boolean b = false;
        for (Book book : allBooks) {
            if (book.getYear() < 2003) {
                b = true;
            }
        }
        return b;
    }

    // 9. Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed 2003 rokiem
    public boolean isAnyPublishedBefore2003Stream(List<Book> allBooks) {
        boolean areThereBefore2003 = allBooks.stream().anyMatch(book -> book.getYear() < 2003);
        return areThereBefore2003;
    }

    // 10. Zwróć wszystkie książki, których tytuł zaczyna się od litery “C” i były one wydane po 2007 roku
    public static List<Book> getBooksStartWithCPublishedAfter2007(List<Book> allBooks) {
        List<Book> startWithC = new ArrayList<>();
        for (Book book : allBooks) {
            if ((book.getTitle().startsWith("C")) && ((book.getYear() > 2007))) {
                startWithC.add(book);
            }
        }
        return startWithC;
    }

    // 11. Dodajmy 100 lat do daty wydania każdej książki (tak, wiem że to nie ma sensu)        // TODO
    public List<Book> add100Years(List<Book> allBooks) {
        int i = 0;
        for (Book book : allBooks) {
            i = book.getYear() + 100;
        }
        return allBooks;
    }

    // 12. Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2
    public List<Book> getBooksWithYearDevidedByTwo(List<Book> allBooks) {
        List<Book> booksDevidedByTwo = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getYear() % 2 == 0) {
                booksDevidedByTwo.add(book);
            }
        }
        return booksDevidedByTwo;
    }

    // 13. Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>)
    public Map<Integer, Book> addMapWithIsbnAndValue() {
        return null;
    }

}











