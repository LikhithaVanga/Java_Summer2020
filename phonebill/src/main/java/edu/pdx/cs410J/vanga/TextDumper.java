package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TextDumper implements PhoneBillDumper {
    /**
     * file name passed in cmd is stored here
     */
    String filename;

    /**
     * constructor
     * @param fname
     */
    public TextDumper(String fname){
        this.filename = fname;
    }

    /**
     * implements overidden method to write to external file
     * @param abstractPhoneBill
     * @throws IOException
     */
    @Override
    public void dump(AbstractPhoneBill abstractPhoneBill) throws IOException {
        ArrayList arr1 = (ArrayList) abstractPhoneBill.getPhoneCalls();
        String phoneCalls[] = new String[arr1.size()];
        File f = new File(filename);
        PrintWriter out = new PrintWriter(filename);
        out.write("");
        out.write(abstractPhoneBill.getCustomer());
        for(int i = 0; i < arr1.size(); ++i){
            System.out.println(arr1.get(i));
            phoneCalls[i] = arr1.get(i).toString();
            out.write("\n");
            out.write(phoneCalls[i]);
        }
        out.close();
    }
}
