package edu.pdx.cs410J.vanga;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

import edu.pdx.cs410J.ParserException;

/**
 * Unit tests for the {@link TextParser} class.
 *
 */
public class TextParserTest {

    public static void fileWriter(String content) throws FileNotFoundException {
        File file = new File("temp.txt");
        file.deleteOnExit();

        PrintWriter pw = new PrintWriter(file);

        if (content != null)
            pw.println(content);

        pw.close();
    }

    // ------------------------------- Error Tests ------------------------------------- //

    @Test(expected = IllegalArgumentException.class)
    public void filenameEmptyThrowsException() throws IllegalArgumentException {
        new TextParser("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void filenameNullThrowsException() throws IllegalArgumentException {
        new TextParser(null);
    }


    @Test
    public void fileNotFoundReturnNull() throws ParserException {
        String filename = "not.exist";

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();
        assertThat(bill, is(nullValue()));
    }

    @Test(expected = ParserException.class)
    public void fileFoundWrongFormatThrowsException1() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "\n" +
                "111-111-1111...111-111-1112...1/15/2020 12:35 am...1/15/2020 12:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        parser.parse();
    }

    @Test(expected = ParserException.class)
    public void fileFoundWrongFormatThrowsException2() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1113...111-111-1112...0/15/2020 19:35 am...1/15/2020 19:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        parser.parse();
    }

    @Test(expected = ParserException.class)
    public void fileFoundWrongFormatThrowsException3() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1113111-111-1112...0/15/2020 19:35 am...1/15/2020 19:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        parser.parse();
    }

    @Test(expected = ParserException.class)
    public void fileFoundWrongFormatThrowsException4() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        parser.parse();
    }

    @Test(expected = ParserException.class)
    public void fileFoundWrongFormatThrowsException5() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1113111-111-1112...0/15/2020 19:35am...1/15/2020 19:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        parser.parse();
    }


    // ------------------------------- Success Tests ------------------------------------- //

    @Test
    public void fileFoundNoContentReturnNull() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = null;

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();
        assertThat(bill, is(nullValue()));
    }

    public void fileExistWithOnlyCustomerName() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();

        assertThat(bill.toString(), containsString("abc's phone bill with 0 phone calls"));
    }

    @Test
    public void fileExistFormatCorrectPassTest1Call() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1111...111-111-1112...1/15/2020 11:35 am...1/15/2020 11:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();

        assertThat(bill.toString(), containsString("abc's phone bill with 1 phone calls"));


    }

    @Test
    public void fileExistFormatCorrectPassTest2Calls() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1111...111-111-1112...1/15/2020 11:35 am...1/15/2020 11:39 am\n" +
                "111-111-1113...111-111-1114...1/15/2020 11:35 am...1/15/2020 11:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();

        assertThat(bill.toString(), containsString("abc's phone bill with 2 phone calls"));


    }

    @Test
    public void fileExistFormatCorrectPassTest2Calls2Newlines() throws ParserException, FileNotFoundException {
        String filename = "temp.txt";
        String content = "abc\n" +
                "111-111-1111...111-111-1112...1/15/2020 11:35 am...1/15/2020 11:39 am\n\n" +
                "111-111-1113...111-111-1114...1/15/2020 11:35 am...1/15/2020 11:39 am";

        // write content
        fileWriter(content);

        TextParser parser = new TextParser(filename);
        PhoneBill bill = parser.parse();

        assertThat(bill.toString(), containsString("abc's phone bill with 2 phone calls"));


    }
}