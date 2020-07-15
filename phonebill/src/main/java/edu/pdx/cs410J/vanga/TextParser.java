package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextParser implements PhoneBillParser {
    /**
     * Stores passed to local variables
     */
    String filename, custName, Caller, Calee, sDate, sTime, sDate1, sTime1;

    /**
     * overridden constructor
     * @param fiName :filename
     * @param cuName : caller name
     * @param caller : caller phone num
     * @param calee : calee ph no
     * @param cDate : date
     * @param cTime : time
     * @param cDate1
     * @param cTime1
     */
    public TextParser(String fiName, String cuName, String caller, String calee, String cDate, String cTime, String cDate1, String cTime1){
        this.filename = fiName;
        this.custName = cuName;
        this.Caller = caller;
        this.Calee = calee;
        this.sDate = cDate;
        this.sTime = cTime;
        this.sDate1 = cDate1;
        this.sTime1 = cTime1;
    }

    /**
     * overridden constructor
     * @param fiName
     */
    public TextParser(String fiName){
        this.filename = fiName;
    }

    /**
     * the parse fn checks to see if file exists, if not creates it
     * if file exist and is empty writes to it
     * oif file has contents read and then write new call to it
     * @return bill with phone calls
     * @throws ParserException
     */
    @Override
    public AbstractPhoneBill parse() throws ParserException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.filename));
        } catch (FileNotFoundException e) {
            System.out.println("Text Dump File with given name does not exist. File created.");
            if(!this.filename.contains("/")){
                PrintWriter out = null;
                try {
                    out = new PrintWriter(this.filename);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is not present.");
                }
                out.write(this.custName);
                out.close();
            }
            else {
                PrintWriter out = null;
                File f = null;
                File f1 = null;
                String v;
                boolean bool = false;
                f = new File(this.filename);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                bool = f1.exists();
                //check if directory exists or not
                if (bool) {
                    try {
                        out = new PrintWriter(this.filename);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    out.write(this.custName);
                    out.close();
                } else {
                    File folder = new File(v);
                    if (folder.mkdir()) {
                        try {
                            out = new PrintWriter(this.filename);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        out.write(this.custName);
                        out.close();
                    } else {
                        System.out.println("Could not create directory");
                        System.exit(1);
                    }
                }
            }
        }
        try {
            sc = new Scanner(new File(this.filename));
        } catch (FileNotFoundException e) {
            System.out.println("File is not present.");
        }
        ArrayList<String> lines = new ArrayList<String>();
        assert sc != null;
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        if(lines.size() == 0){
            System.err.println("The text file is empty!!!!");
            PhoneBill bill = new PhoneBill(custName);
            PhoneCall call = new PhoneCall(Caller, Calee, sDate, sTime, sDate1, sTime1);
            //bill.addPhoneCall(call);
            return bill;
            //System.exit(1);
        }
        else{
            int sze = lines.size();
            PhoneBill bill = new PhoneBill(lines.get(0));
            //This for loop checks each and every detail of every flight in the text file
            for(int i = 1; i < sze; ++i) {
                String[] words = lines.get(i).split(" ");

                PhoneCall call = new PhoneCall(words[3],words[5],words[7], words[8].concat(" ").concat(words[9]), words[11], words[12].concat(" ").concat(words[13]));
                bill.addPhoneCall(call);
            }
            //System.out.println(bill.getPhoneCalls());
            return bill;
        }
    }


}
