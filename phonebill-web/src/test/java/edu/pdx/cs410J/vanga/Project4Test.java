package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Project4Test extends InvokeMainTestCase
{
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project4.class, args );
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void NoCommandLineArguments() {
        String[] arr = {};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));;
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testTooManyCommandLineArguments() {
        String[] arr = {"-port", "8080", "-host", "localhost", "erg", "354", "43", "3/15/2017", "10:39", "am","et", "3/15/2017", "19:45","pm","xyz"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));;
        assertThat(result.getTextWrittenToStandardError(), containsString("Too many command line arguments"));
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testToofew7CommandLineArguments() {
        String[] arr = {"-port", "8080", "-host", "localhost","erg", "354", "43", "3/15/2017", "10:39", "am"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test
    public void testReadMEOption1() {
        String[] arr = {"-README"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Project 4 README by Likhitha for CS510J Summer"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test
    public void testReadMEOption() {
        String[] arr = {"-README","-port", "8080", "-host", "localhost"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Project 4 README by Likhitha for CS510J"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test
    public void search7Test() {
        String[] arr = {"-README","-port", "8080", "-host", "localhost", "-search", "rwef"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
        assertThat(result.getTextWrittenToStandardError(),containsString("Missing command line arguments"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test
    public void search7Test1() {
        String[] arr = {"-README","-port", "8080", "-host", "localhost", "-search", "rwef"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));
        //assertThat(result.getTextWrittenToStandardError(), containsString("MISSING CMD LINE ARGS FOR SEARCH"));
        assertThat(result.getTextWrittenToStandardError(),containsString("Missing command line arguments"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test
    public void search9Test() {
        String[] arr = {"-port", "8080", "-host", "localhost", "rwef", "edf", "rwef", "edf", "rwef", "edf", "rwef", "edf", "rwef", "edf"};
        MainMethodResult result = invokeMain(arr);
        assertThat(result.getExitCode(), equalTo(1));
        //assertThat(result.getTextWrittenToStandardError(), containsString("MISSING CMD LINE ARGS FOR SEARCH"));
        assertThat(result.getTextWrittenToStandardError(),containsString("Too many command line arguments"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test//(expected = ArrayIndexOutOfBoundsException.class)
    public void argPort() {
        String[] arr = {"-port"};
        MainMethodResult result = invokeMain(arr);
        //assertThat(result.getExitCode(), equalTo(null));
        //assertThat(result.getTextWrittenToStandardError(), containsString("MISSING CMD LINE ARGS FOR SEARCH"));
        assertThat(result.getTextWrittenToStandardError(),containsString("Missing port number argument"));
    }

    /**
     * Test for readme option with other command line arguments
     */
    @Test//(expected = ArrayIndexOutOfBoundsException.class)
    public void argPort1() {
        String[] arr = {"-port", "8080","-host"};
        MainMethodResult result = invokeMain(arr);
        //assertThat(result.getExitCode(), equalTo(null));
        //assertThat(result.getTextWrittenToStandardError(), containsString("MISSING CMD LINE ARGS FOR SEARCH"));
        assertThat(result.getTextWrittenToStandardError(),containsString("Missing hostname argument"));
    }

}
