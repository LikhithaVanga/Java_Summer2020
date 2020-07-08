package edu.pdx.cs410J.vanga;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class PhoneBillTest {
    @Test
    public void getCustomer() {
        var name = "Likhitha";
        PhoneBill bill = new PhoneBill(name);
        assertThat(bill.getCustomer(), not(nullValue()));
        assertThat(bill.getCustomer(), containsString(name));

    }

    @Test
    public void getPhoneCalls() {
        var name = "Likhitha";
        PhoneBill bill = new PhoneBill(name);

        var calls = bill.getPhoneCalls();

        assertTrue(calls.isEmpty());
    }

}
