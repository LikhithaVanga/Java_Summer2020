package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.ParserException;
import org.apache.tools.ant.filters.TokenFilter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class PrettyPrinterTest {

    @Test
    public void getPrettyoutput() throws IOException, ParseException {
        PhoneBill b = new PhoneBill("Likhitha");
        PhoneCall c = new PhoneCall("503-449-7833", "209-401-9876", "10/10/2020 10:00 am", "10/10/2020 10:00 am");
        PhoneCall d = new PhoneCall("503-449-7833", "209-404-9876", "10/10/2020 10:01 am", "10/10/2020 10:00 am");
        b.addPhoneCall(c);
        b.addPhoneCall(d);
        PrintWriter writer = null;
        PrettyPrinter dumper = new PrettyPrinter(writer);
        //dumper.dump(b);
        String s = dumper.getPrettyPrint(b);
        assertThat(s, containsString("Likhitha"));



    }
}
