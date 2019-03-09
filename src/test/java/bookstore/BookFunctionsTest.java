package bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookFunctionsTest {

    List<Book> testedBooks = new ArrayList<>();

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

    BookFunctions bookFunctions = new BookFunctions();

    @Test
    public void test1() {
        Book book = bookFunctions.searchByIsbn(9780596150211L, testedBooks);
        Assert.assertEquals("Java in a nutshell", book.getTitle());
    }

    @Test
    public void test1A() {
        Book book = bookFunctions.searchByIsbnStream(9780596150211L, testedBooks);
        Assert.assertEquals("Java in a nutshell", book.getTitle());
    }

    @Test
    public void test2() {
        List<Book> twoLastBooks = bookFunctions.getTwoLast(testedBooks);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Java: A Beginner's Guide", preLastBook.getTitle());
        Assert.assertEquals("Head First Design Patterns", lastBook.getTitle());
    }

    @Test
    public void test2A() {
        List<Book> twoLastBooks = bookFunctions.getTwoLastStream(testedBooks);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Java: A Beginner's Guide", preLastBook.getTitle());
        Assert.assertEquals("Head First Design Patterns", lastBook.getTitle());
    }

    @Test                                          // method TODO
    public void test3() {
        Book book = bookFunctions.getEarliestPublished(testedBooks);
        Assert.assertEquals("Head First Design Patterns", book.getTitle());
    }

    @Test                                        //TODO
    public void test4() {
    }

    @Test
    public void test5() {
        int yearsSum = bookFunctions.sumAllYears(testedBooks);
        Assert.assertEquals(12071, yearsSum);
    }

    @Test
    public void test5A() {
        int yearsSum = bookFunctions.sumAllYearsStream(testedBooks);
        Assert.assertEquals(12071, yearsSum);
    }

    @Test
    public void test6() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007(testedBooks);
        Assert.assertEquals(4, booksAfter2007);
    }

    @Test
    public void test6A() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007Stream(testedBooks);
        Assert.assertEquals(4, booksAfter2007);
    }

    @Test
    public void test7() {
        boolean trueOrFalse = bookFunctions.areBooksPublishedAfter2000(testedBooks);
        Assert.assertEquals(true, trueOrFalse);
    }

    @Test
    public void test7A() {
        boolean trueOrFalse = bookFunctions.areBooksPublishedAfter2000Stream(testedBooks);
        Assert.assertEquals(true, trueOrFalse);
    }

    @Test
    public void test8() {
        int yearsMediana = bookFunctions.getYearMediana(testedBooks);
        Assert.assertEquals(2011, yearsMediana);
    }

    @Test
    public void test8A() {
        int yearsMediana = bookFunctions.getYearMedianaStream(testedBooks);
        Assert.assertEquals(2011, yearsMediana);
    }

    @Test
    public void test9() {
        boolean trueOrFalse = bookFunctions.isAnyPublishedBefore2003(testedBooks);
        Assert.assertEquals(false, trueOrFalse);
    }

    @Test
    public void test9A() {
        boolean trueOrFalse = bookFunctions.isAnyPublishedBefore2003Stream(testedBooks);
        Assert.assertEquals(false, trueOrFalse);
    }

    @Test
    public void test10() {
        List<Book> booksWithCPublishedAfter2007 = bookFunctions.getBooksStartWithCPublishedAfter2007(testedBooks);
        Assert.assertEquals(true, booksWithCPublishedAfter2007.isEmpty());
    }

    @Test
    public void test11() {
        List<Book> bookPlus100 = bookFunctions.add100Years(testedBooks);
        Book firstExample = bookPlus100.get(0);
        Book secondExample = bookPlus100.get(1);
        Assert.assertEquals(2114, firstExample.getYear());
        Assert.assertEquals(2111, secondExample.getYear());
    }

    @Test
    public void test12() {
    List<Book> booksWithDivision = bookFunctions.getBooksWithYearDevidedByTwo(testedBooks);
    Book firstSample = booksWithDivision.get(0);
    Book secondSample = booksWithDivision.get(1);
    Assert.assertEquals("Java in a nutshell", firstSample.getTitle());
    Assert.assertEquals("Design Patterns in Java", secondSample.getTitle());
    }

//    @Test
//    public void test13() {
//        Map<Integer, Book> mapWithIsbnAndValue = bookFunctions.addMapWithIsbnAndValue(testedBooks);
//        Map<Integer, Book> firstSample = mapWithIsbnAndValue.get(9780596150211L, book1);
//        Map<Integer, Book> secondSample = mapWithIsbnAndValue.get(9780983384021L, book2);
//        Assert.assertEquals(Map<9780596150211L, book1>, );
//    }

}
