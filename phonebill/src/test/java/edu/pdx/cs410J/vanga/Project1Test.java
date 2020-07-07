package edu.pdx.cs410J.vanga;

import org.junit.Test;
import edu.pdx.cs410J.InvokeMainTestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can handle the calls
 * to {@link System#exit(int)} and the like.
 */
public class Project1Test extends InvokeMainTestCase {

  private MainMethodResult invokeMain(String... args) {

    return invokeMain(Project1.class, args );
  }

  @Test
  public void readmeCanBeReadAsResource() throws IOException {
    try (
            InputStream readme = Project1.class.getResourceAsStream("README.txt");
    ) {
      assertThat(readme, not(nullValue()));
      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      String line = reader.readLine();
      assertThat(line, containsString("This is a README file!"));
    }
  }

  /**
   * Test to check when there are no cmd line args
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
  public void test3CommandLineArguments(){
    MainMethodResult result = invokeMain("something", "S2", "S3");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing call Date"));
  }

  @Test
  public void test4CommandLineArguments(){
    MainMethodResult result = invokeMain("something", "S2", "S3", "S4");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing call start time"));
  }

  @Test
  public void test5CommandLineArguments(){
    MainMethodResult result = invokeMain("something", "S2", "S3", "S4", "S5");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing call Date"));
  }

  @Test
  public void test6CommandLineArguments(){
    MainMethodResult result = invokeMain("something", "S2", "S3", "S4", "S5", "S6");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing call end time"));
  }

  /**
   * Test to verify display message is same as inputed cmd line args
   */


  /**
   * Test to check when there are too many cmd line args
   */
  @Test
  public void tooManyCLA() {
    MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 AM", "01/01/2020", "02:00 AM", "-print", "-readme", "hgfftg"});
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Too many args"));
  }

}
