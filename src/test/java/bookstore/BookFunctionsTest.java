package bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BookFunctionsTest {

    private List<Book> testedBooks = new ArrayList<>();

    @Before
    public void setup() {
        Book book1 = new Book(1, "Java in a nutshell", 9780596150211L, 2014, "paperback", null, null);
        Book book2 = new Book(2, "Advanced Programming Techniques", 9780983384021L, 2011, "hardcover", null, null);
        Book book3 = new Book(3, "Design Patterns in Java", 9780134277882L, 2006, "paperback", null, null);
        Book book4 = new Book(4, "Java: The Complete Reference", 9781260440232L, 2018, "hardcover", null, null);
        Book book5 = new Book(5, "Java: A Beginner's Guide", 9781260440218L, 2018, "paperback", null, null);
        Book book6 = new Book(6, "Head First Design Patterns", 9780596007126L, 2004, "paperback", null, null);
        testedBooks.add(book1);
        testedBooks.add(book2);
        testedBooks.add(book3);
        testedBooks.add(book4);
        testedBooks.add(book5);
        testedBooks.add(book6);
    }

    private BookFunctions bookFunctions = new BookFunctions();

    @Test
    public void searchByIsbn() {
        Book book = bookFunctions.searchByIsbn(9780596150211L, testedBooks);
        Assert.assertEquals("Java in a nutshell", book.getTitle());
    }

    @Test
    public void searchByIsbnStream() {
        Book book = bookFunctions.searchByIsbnStream(9780596150211L, testedBooks);
        Assert.assertEquals("Java in a nutshell", book.getTitle());
    }

    @Test
    public void getTwoLast() {
        List<Book> twoLastBooks = bookFunctions.getTwoLast(testedBooks);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Java: A Beginner's Guide", preLastBook.getTitle());
        Assert.assertEquals("Head First Design Patterns", lastBook.getTitle());
    }

    @Test
    public void getTwoLastStream() {
        List<Book> twoLastBooks = bookFunctions.getTwoLastStream(testedBooks);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Java: A Beginner's Guide", preLastBook.getTitle());
        Assert.assertEquals("Head First Design Patterns", lastBook.getTitle());
    }

    @Test                                          // method TODO
    public void getEarliestPublished() {
        Book book = bookFunctions.getEarliestPublished(testedBooks);
        Assert.assertEquals("Head First Design Patterns", book.getTitle());
    }

    @Test                                        //TODO
    public void getLastPublished() {
    }

    @Test
    public void sumAllYears() {
        int yearsSum = bookFunctions.sumAllYears(testedBooks);
        Assert.assertEquals(12071, yearsSum);
    }

    @Test
    public void sumAllYearsStream() {
        int yearsSum = bookFunctions.sumAllYearsStream(testedBooks);
        Assert.assertEquals(12071, yearsSum);
    }

    @Test
    public void getBooksPublishedAfter2007() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007(testedBooks);
        Assert.assertEquals(4, booksAfter2007);
    }

    @Test
    public void getBooksPublishedAfter2007Stream() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007Stream(testedBooks);
        Assert.assertEquals(4, booksAfter2007);
    }

    @Test
    public void areBooksPublishedAfter2000() {
        boolean trueOrFalse = bookFunctions.areBooksPublishedAfter2000(testedBooks);
        Assert.assertEquals(true, trueOrFalse);
    }

    @Test
    public void areBooksPublishedAfter2000Stream() {
        boolean trueOrFalse = bookFunctions.areBooksPublishedAfter2000Stream(testedBooks);
        Assert.assertEquals(true, trueOrFalse);
    }

    @Test
    public void getYearMediana() {
        int yearsMediana = bookFunctions.getYearMediana(testedBooks);
        Assert.assertEquals(2011, yearsMediana);
    }

    @Test
    public void getYearMedianaStream() {
        int yearsMediana = bookFunctions.getYearMedianaStream(testedBooks);
        Assert.assertEquals(2011, yearsMediana);
    }

    @Test
    public void isAnyPublishedBefore2003() {
        boolean trueOrFalse = bookFunctions.isAnyPublishedBefore2003(testedBooks);
        Assert.assertEquals(false, trueOrFalse);
    }

    @Test
    public void isAnyPublishedBefore2003Stream() {
        boolean trueOrFalse = bookFunctions.isAnyPublishedBefore2003Stream(testedBooks);
        Assert.assertEquals(false, trueOrFalse);
    }

    @Test
    public void getBooksStartWithCPublishedAfter2007() {
        List<Book> booksWithCPublishedAfter2007 = bookFunctions.getBooksStartWithCPublishedAfter2007(testedBooks);
        Assert.assertEquals(true, booksWithCPublishedAfter2007.isEmpty());
    }

    @Test
    public void add100Years() {
        List<Book> bookPlus100 = bookFunctions.add100Years(testedBooks);
        Book firstExample = bookPlus100.get(0);
        Book secondExample = bookPlus100.get(1);
        Assert.assertEquals(2114, firstExample.getYear());
        Assert.assertEquals(2111, secondExample.getYear());
    }

    @Test
    public void getBooksWithYearDevidedByTwo() {
        List<Book> booksWithDivision = bookFunctions.getBooksWithYearDevidedByTwo(testedBooks);
        Book firstSample = booksWithDivision.get(0);
        Book secondSample = booksWithDivision.get(1);
        Assert.assertEquals("Java in a nutshell", firstSample.getTitle());
        Assert.assertEquals("Design Patterns in Java", secondSample.getTitle());
    }

//    @Test
//    public void addMapWithIsbnAndValue() {
//        Map<Integer, Book> mapWithIsbnAndValue = bookFunctions.addMapWithIsbnAndValue(testedBooks);
//        Map<Integer, Book> firstSample = mapWithIsbnAndValue.get(9780596150211L, book1);
//        Map<Integer, Book> secondSample = mapWithIsbnAndValue.get(9780983384021L, book2);
//        Assert.assertEquals(Map<9780596150211L, book1>, );
//    }

}
