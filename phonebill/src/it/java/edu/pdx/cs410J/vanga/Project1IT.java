package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {

        return invokeMain( Project1.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments(){
      MainMethodResult result = invokeMain();
      assertThat(result.getExitCode(), equalTo(1));
      assertThat(result.getTextWrittenToStandardError(), containsString("No arguments!"));
  }
    @Test
    public void test1CommandLineArguments(){
        MainMethodResult result = invokeMain("something");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing Caller number"));
    }

    @Test
    public void test2CommandLineArguments(){
        MainMethodResult result = invokeMain("something", "S2");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing Calee number"));
    }

    @Test
    public void displayoutputMSG() {
        MainMethodResult result = invokeMain(Project1.class, "Likhitha", "503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardOut(), containsString("call from 503-449-7833"));

    }

    @Test
    public void ifArg7isReadme() {
        MainMethodResult result = invokeMain(Project1.class,  "Likhitha","503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am", "-README");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));

    }

    @Test
    public void ifArg7isPrint() {
        MainMethodResult result = invokeMain(Project1.class,  "Likhitha","503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am", "-PRINT","-README");
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));

    }
    @Test
    public void test2CommandLineArgumentsforExit() {
        MainMethodResult result = invokeMain("something", "S2");
        assertThat(result.getExitCode(), equalTo(1));
    }

    @Test
    public void testNoCommandLineArgumentsforexit() {
        MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(), equalTo(1));
    }

    @Test
    public void ifArg7isReadmeforSystemexit() {
        MainMethodResult result = invokeMain(Project1.class, "Likhitha", "503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am", "-README");
        assertThat(result.getExitCode(), equalTo(1));
    }



}