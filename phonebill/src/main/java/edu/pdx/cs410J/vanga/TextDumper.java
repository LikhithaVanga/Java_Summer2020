package edu.pdx.cs410J.vanga;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;

import edu.pdx.cs410J.PhoneBillDumper;

/**
 * A TextDumper dumps the contents of a phone bill 4 (including its calls) to a text file.
 *
 * @author Likhitha V
 *
 */
public class TextDumper implements PhoneBillDumper<PhoneBill> {

    private String filename;

    /**
     * create a TextDumper with a filename
     *
     * @param filename
     * @throws IllegalArgumentException
     */
    public TextDumper(String filename) throws IllegalArgumentException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is invalid in text dumper");
        }

        this.filename = filename;
    }

    /**
     * Dumps a phone bill to some destination.
     *
     * @param bill
     *            PhoneBill
     * @throws IOException
     */
    @Override
    public void dump(PhoneBill bill) throws IOException {
        File file = new File(filename);
//		file.deleteOnExit();

        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        String customer = bill.getCustomer();
        pw.println(customer);

        Collection<PhoneCall> calls = bill.getPhoneCalls();
        DateFormat dateFormat = new SimpleDateFormat(PhoneCall.PARSE_DATE_PATTERN, Locale.US);

        for (PhoneCall call : calls) {
            pw.println(call.getCaller() + "..." + call.getCallee() + "..." + dateFormat.format(call.getStartTime()) + "..." + dateFormat.format(call.getEndTime()));
        }

        pw.close();
    }

}