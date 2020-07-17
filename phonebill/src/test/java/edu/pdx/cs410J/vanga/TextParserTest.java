package edu.pdx.cs410J.vanga;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextParserTest {
    public PhoneCall phoneCall1;
    public PhoneCall phoneCall2;
    public PhoneBill phoneBill3;

    @Before
    public void runSetup () {
        phoneCall1 = new PhoneCall("Likhi", "503-440-2707", "503-645-3231","07/01/2019", "01:23", "07/01/2019", "01:24");
        phoneCall2 = new PhoneCall("Vanga", "503-440-2707", "503-645-3231","07/01/2019", "01:23", "07/01/2019", "01:24");
        phoneBill3 = new PhoneBill();
        phoneBill3.addPhoneCall(phoneCall1);
        phoneBill3.addPhoneCall(phoneCall2);
        TextDumper.dump(phoneBill3,"PhoneBill2.txt");
    }

    /**
     * Tests readme as a resource
     * @throws IOException
     */
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
     * Loads a file that has two lines and tests that it works
     */
    @Test
    public void loadTwoFile() {
        PhoneBill testBill = TextParser.parse("PhoneBill2.txt");
        assertThat(testBill.getCustomer(),equalTo("Likhi"));
        PhoneBill test2Bill = new PhoneBill();
        test2Bill.addPhoneCall(phoneCall1);
        test2Bill.addPhoneCall(phoneCall2);
        assertThat(testBill, equalTo(test2Bill));
    }

}