package edu.pdx.cs410J.vanga;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneBillTest {

    PhoneBill bill;
    PhoneCall call;

    @Before
    public void runBefore () {
        call = new PhoneCall("Pranee", "503-440-2707", "503-645-3231", "06/01/1990", "22:23", "06/01/1990", "22:29");
        bill = new PhoneBill(call);
    }

    /**
     * Tests phone bill to ensure that the equality of two different phone bills with the same information works
     */
    @Test
    public void phoneBillEqualityTest () {
        PhoneBill bill2 = new PhoneBill(call);
        assertThat(bill2,equalTo(bill));
    }

    /**
     * Tests that the customer method works properly
     */
    @Test
    public void getCustomerTest () {
        assertThat(bill.getCustomer(),equalTo("Pranee"));
    }

    /**
     * Tests that the add phone class method works properly
     */
    @Test
    public void addPhoneClassTest () {
        bill.addPhoneCall(call);

        PhoneBill bill2 = new PhoneBill(call);
        bill2.addPhoneCall(call);

        assertThat(bill.getPhoneCalls(), equalTo(bill2.getPhoneCalls()));
    }

    /**
     * Tests the get phone calls
     */
    @Test
    public void getPhoneCallsTest () {
        List<PhoneCall> phoneList = new ArrayList<PhoneCall>();
        phoneList.add(call);
        assertThat(bill.getPhoneCalls(), equalTo(phoneList));
    }

    /**
     * Tests the get phone calls
     */
    @Test
    public void testPhoneCall () {
        PhoneBill test2 = new PhoneBill(new PhoneCall("","","","","","",""));
    }


}
