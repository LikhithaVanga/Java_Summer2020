package edu.pdx.cs410J.vanga;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextDumperTest {
    public PhoneCall phoneCall1;
    public PhoneCall phoneCall2;

    @Before
    public void runSetup () {
        phoneCall1 = new PhoneCall("Likhi", "503-440-2707", "503-645-3231","07/01/2019", "01:23", "07/01/2019", "01:24");
        phoneCall2 = new PhoneCall("Vanga", "503-440-2707", "503-645-3231","07/01/2019", "01:23", "07/01/2019", "01:24");
    }

    /**
     * Tests the dump function for the text dumper class
     */
    @Test
    public void pasteValues () {
        PhoneBill test1 = new PhoneBill();
        test1.addPhoneCall(phoneCall1);
        test1.addPhoneCall(phoneCall2);
        TextDumper.dump(test1,"PhoneBill6.txt");
    }

}