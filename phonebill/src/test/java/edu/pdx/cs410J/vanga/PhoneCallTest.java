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

  @Test
  public void getCallerNeedsToBeImplemented(){
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCaller(), not(nullValue()));
  }

  @Test
  public void getCalleeNeedsToBeImplemented(){
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), not(nullValue()));
  }

  @Test
  public void invalidCallerNumber(){
    PhoneCall call = new PhoneCall("ABCD", "345-876-3456", "", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCaller(), not(nullValue()));
  }

  @Test
  public void invalidCaleeNumber(){
    PhoneCall call = new PhoneCall("503-449-7833", "ABCD", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), not(nullValue()));
  }

  @Test
  public void initiallyAllPhoneCallsHaveTheSameCallee() {
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getCallee(), containsString("34"));
  }

  @Test
  public void forProject1ItIsOkayIfGetStartTimeReturnsNull() {
    PhoneCall call = new PhoneCall("503-449-7833", "345-876-3456", "01/01/2020", "1:00 am", "01/01/2020", "1:00 am");
    assertThat(call.getStartTime(), is(nullValue()));
  }







  
}
