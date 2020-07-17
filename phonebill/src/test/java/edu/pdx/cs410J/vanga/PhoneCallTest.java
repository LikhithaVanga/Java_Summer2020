package edu.pdx.cs410J.vanga;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out you program.
 */
public class PhoneCallTest {
  PhoneCall call;

  @Before
  public void initialize () {
    call = new PhoneCall("Pranee","503-440-2707","503-645-3231","01/02/2014","22:45","01/02/2014","22:50");

  }

  /**
   * Tests the getcaller method for phone calls
   */
  @Test
  public void getCallerTest() {

    assertThat(call.getCaller(), is(equalTo("503-440-2707")));
  }

  /**
   * Tests that the getCallee method
   */
  @Test
  public void getCalleeTest() {

    assertThat(call.getCallee(), is(equalTo("503-645-3231")));
  }

  /**
   * Tests the getStartingTime method
   */
  @Test
  public void getStartingTest() {

    assertThat(call.getStartTimeString(), is(equalTo("01/02/2014 22:45")));
  }

  /**
   * Tests the getEndingTime method
   */
  @Test
  public void getEndingTest() {

    assertThat(call.getEndTimeString(), is(equalTo("01/02/2014 22:50")));
  }

  /**
   * Tests the getCustomerString method
   */
  @Test
  public void getCustomerTest() {

    assertThat(call.getCustomer(), is(equalTo("Pranee")));
  }

  /**
   * Tests the toString method
   */
  @Test
  public void toStringTest() {

    System.out.println(call.toString());
  }

  /**
   * Tests the print info method that is used for text dumping
   */
  @Test
  public void printInfoTest() {

    assertThat(call.printInfo(), equalTo("Pranee 503-440-2707 503-645-3231 01/02/2014 22:45 01/02/2014 22:50"));
  }

  /**
   * Tests the not equal method for two phone calls
   */
  @Test
  public void notEqual() {
    PhoneCall call2 = new PhoneCall("likhi","503-440-2707","503-645-3231","01/02/2014","22:45","01/02/2014","22:50");
    assertThat(call,not(equalTo(call2)));
  }


}
