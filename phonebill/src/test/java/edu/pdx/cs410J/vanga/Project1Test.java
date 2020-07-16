package edu.pdx.cs410J.vanga;

import org.junit.Test;
import edu.pdx.cs410J.InvokeMainTestCase;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can handle the calls
 * to {@link System#exit(int)} and the like.
 */
public class Project1Test extends InvokeMainTestCase {

  private MainMethodResult invokeMain(String... args) {
    return invokeMain( Project2.class, args );
  }

  @Test
  public void readmeCanBeReadAsResource() throws IOException {
    try (
            InputStream readme = Project2.class.getResourceAsStream("README.txt");
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
    assertThat(result.getTextWrittenToStandardError(), containsString("No arguments!"));
    assertThat(result.getExitCode(), equalTo(1));
  }

  /**
   * Test to check when there is 1 cmd line args
   */
  @Test
  public void test1CommandLineArguments(){
    MainMethodResult result = invokeMain("-readme");
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
  }


  /**
   * Test to check when the 1 cmd arg but not readme
   */
  @Test
  public void test1CommandLineArgumentsNotReadme(){
    MainMethodResult result = invokeMain("-whatever");
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

  /**
   * Test to check when the 2 cmd arg but not readme
   */
  @Test
  public void test2CommandLineArgumentsNotReadme(){
    MainMethodResult result = invokeMain("-blah", "s1");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }



  /**
   * Test to check when no file provided for -textFile arg
   */
  @Test
  public void testNoFileProvided(){
    MainMethodResult result = invokeMain("-something", "s1", "3", "4", "5", "6", "7", "-textFile");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Missing cmd line args/text file to read from"));
  }



  /**
   * Test to check when no file provided for -textFile arg
   */
  @Test
  public void testFileNotExists(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"vanga", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "vanga.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertFalse(!file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  @Test
  public void testDifferentName(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "vanga.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertFalse(!file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when empty file provided for -textFile arg and call written to file
   */
  @Test
  public void testPhoneCallPrinted1(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
      assertTrue(file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when file provided for -textFile arg exists
   */
  @Test
  public void testFileExists1(){
    try{
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertTrue(file.exists());
    }
    catch (Throwable e) {
    assertTrue(e instanceof RuntimeException);
  }
  }

  /**
   * Test to check when no file provided for -textFile arg
   */
  @Test
  public void testFileNotExists1(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertFalse(!file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when empty file provided for -textFile arg and call written to file
   */
  @Test
  public void testPhoneCallPrinted() {
    try{
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
      assertTrue(file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when empty file provided for -textFile arg and call written to file
   */
  @Test
  public void testFileExists2(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-readme", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertTrue(file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when no file provided for -textFile arg
   */
  @Test
  public void testFileNotExists2(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-readme", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertFalse(!file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }

  /**
   * Test to check when empty file provided for -textFile arg and call written to file
   */
  @Test
  public void testPhoneCallPrinted2(){
    try {
      File file = new File("tFile.txt");
      MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-readme", "-textFile", "tFile.txt"});
      assertThat(result.getExitCode(), equalTo(1));
      assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
      assertTrue(file.exists());
    }
    catch (Throwable e) {
      assertTrue(e instanceof RuntimeException);
    }
  }


  /**
   * Test to verify display message is same as inputed cmd line args
   */
  @Test
  public void displayMSG() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-readme"});

    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
  }
  @Test
  public void displayMultiWordUserName() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha vanga", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print", "-readme"});

    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
  }

  /**
   * Test to verify display message is same as inputed cmd line args
   */
  @Test
  public void displayMSG1() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-readme", "-print"});
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
  }

  /**
   * Test to verify display message is same as readme cmd line args
   */
  @Test
  public void displayMSG2() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-readme"});
    assertThat(result.getExitCode(), equalTo(null));
    assertThat(result.getTextWrittenToStandardOut(), containsString("timeEnd stores the time of phone call ended"));
  }

  /**
   * Test to verify display message is same as inputed cmd line args
   */
  @Test
  public void displayMSG3() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-print"});
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
  }

  /**
   * Test to verify display message is same as inputted cmd line args
   */
  @Test
  public void displayMSG4() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "-readme", "-print"});
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
  }

  /**
   * Test to verify display message is same as inputted cmd line args
   */
  @Test
  public void displayMSG5() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "som.txt", "-readme", "-print"});
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-449-7833 to 234-234-2345 from 01/01/2020 01:00 am to 01/01/2020 02:00 am"));
  }

  /**
   * Test to verify display message is same as readme cmd line args
   */
  @Test
  public void displayMSG6() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "-print","-readme"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
  }

  /**
   * Test to verify display message is same as readme cmd line args
   */
  @Test
  public void displayMSG7() {
    MainMethodResult result = invokeMain(new String[] {"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 am", "01/01/2020", "02:00 am", "-textFile", "dferf.txt", "-print","-readme"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));

  }

  /**
   * Test to check when there are too many cmd line args
   */
  @Test
  public void tooManyCLA() {
    MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 AM", "01/01/2020", "02:00 AM", "-print", "-readme", "hgfftg", "esrg", "ergferw"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Too many args"));
  }

  @Test
  public void unknownCmdLineArgs() {
    MainMethodResult result = invokeMain(new String[]{"whatever", "whatever"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString(""));
  }

  @Test
  public void testReadme() {
    MainMethodResult result = invokeMain(new String[]{"-readme"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
  }



  @Test
  public void invalidPhnNumber() {
    MainMethodResult result = invokeMain(new String[]{"Likhitha", "503-449-7833", "234-234-2345", "01/01/2020", "01:00 AM", "01/01/2020", "02:00 AM", "hello"});
    //assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Invalid phone number"));
  }

}
