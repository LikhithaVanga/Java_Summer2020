package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.PhoneBillDumper;

import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TextDumper takes strings (PhoneBill) and outputs it to a text file or any other output file.
 */
public class TextDumper implements PhoneBillDumper<PhoneBill> {

    @Deprecated
    public void dump (PhoneBill calls) {
        return;
    }

    /**
     *
     * @param calls PhoneBill that wants to be dumped
     * @param filename filename to print the output to
     */
    public static void dump (PhoneBill calls, String filename) {

        // Get the file name, with an exception if there was some error creating files.
        File f1 = new File(filename);
        try {
            if (!f1.exists()) {
                f1.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error creating new file");
        }

        // Create a print writer to print by line to the bill
        try {
            FileWriter fileWritter = new FileWriter(f1);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            PrintWriter pw = new PrintWriter(bw);

            for(PhoneCall call : calls.getPhoneCalls()) {
                pw.println(call.printInfo());
            }
            pw.close();
        } catch(Exception e){
            throw new IllegalArgumentException("Cannot load file");
        }
    }
}