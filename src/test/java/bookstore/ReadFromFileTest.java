package bookstore;

import org.junit.Assert;
import org.junit.Test;

public class ReadFromFileTest {

    private ReadFromFile readFromFile = new ReadFromFile();

    @Test
    public void readBook() {
        Book book = readFromFile.readBook("");
        Assert.assertEquals("Test Drive Development", );
    }


}
