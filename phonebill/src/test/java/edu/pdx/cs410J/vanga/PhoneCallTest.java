package edu.pdx.cs410J.vanga;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out you program.
 */
public class PhoneCallTest {

  //(expected = UnsupportedOperationException.class)
  //@Test(expected = UnsupportedOperationException.class)

  /**
   * Test to check start time string is implemented
   */
  @Test(expected = UnsupportedOperationException.class)
  public void getStartTimeStringNeedsToBeImplemented() {
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "", "1:00 am", "", "2:00 am");
    call.getStartTimeString();
  }

  /**
   * Test to check if caller number is implemented
   */
  @Test
  public void getCallerNeedsToBeImplemented(){
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCaller(), not(nullValue()));
  }

  /**
   * Test to check if calee is implemented
   */
  @Test
  public void getCalleeNeedsToBeImplemented(){
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), not(nullValue()));
  }

  /**
   * Test to check if caller number is valid
   */
  @Test
  public void invalidCallerNumber(){
    PhoneCall call = new PhoneCall("ABCD", "345-876-3456", "", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCaller(), not(nullValue()));
  }

  /**
   * Test to check if calee number is valid
   */
  @Test
  public void invalidCaleeNumber(){
    PhoneCall call = new PhoneCall("503-449-7833", "ABCD", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), not(nullValue()));
  }

  /**
   * Test to check if the calee is the same for inintial calls
   */
  @Test
  public void initiallyAllPhoneCallsHaveTheSameCallee() {
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), containsString("34"));
  }

  /**
   * Test to check if it is ok to return start time as " or null
   */
  @Test
  public void forProject1ItIsOkayIfGetStartTimeReturnsNull() {
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getStartTime(), is(nullValue()));
  }

//  @Test
//  public void testDateformat(){
//    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "", "1:00 am", "01/01/2020", "1:00 am");
//    assertThat(call.validateJavaDate(""), containsString(""));
//  }
//
//  @Test(expected = NullPointerException.class)
//  public void testDateformatNull(){
//    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", null, "1:00 am", "01/01/2020", "1:00 am");
//    //assertThat(call.validateJavaDate(null), is(nullValue()));
//    assertThat(call.validateJavaDate(null), containsString("Too many args"));
//  }







  
}
