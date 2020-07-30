package edu.pdx.cs410J.vanga;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;


public class PhoneBillTest {

    /**
     * Tests to check customer name is not null
     */
    @Test
    public void getCustomerTest() {
        var name = "name";
        PhoneBill b = new PhoneBill(name);

        assertThat(b.getCustomer(), not(nullValue()));
        assertThat(b.getCustomer(), containsString(name));
    }


    /**
     * Getting phone calls for an empty Phone Bill works.
     */
    @Test
    public void getPhoneCallsTest() {
        var name = "name";
        PhoneBill b = new PhoneBill(name);

        var calls = b.getPhoneCalls();

        assertTrue(calls.isEmpty());
    }







    @Test
    public void compareTocaller() {
        PhoneBill b = new PhoneBill("Likhitha");
        String callerNumber = "503-449-7833";
        PhoneCall c = new PhoneCall("503-449-7833", "209-401-9876", "10/10/2020 10:00 am", "10/10/2020 10:00 am");
        PhoneCall d = new PhoneCall("503-449-7833", "209-404-9876", "10/10/2020 10:00 am", "10/10/2020 10:00 am");
        int caller = c.compareTo(c);
        assertEquals(caller, 0);
    }





}
