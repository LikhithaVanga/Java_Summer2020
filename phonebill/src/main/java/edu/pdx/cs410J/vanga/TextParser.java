package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.PhoneBillParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextParser implements PhoneBillParser {

    /**
     * Helper function to parse a string into a string array
     * @param line string to parse into string array
     * @return string array to return
     */
    public static String[] parseCall (String line) {
        String[] strArray = line.trim().split("\\s+");
        if (strArray.length != 7) {
            throw  new IllegalArgumentException("Line read in file was not a phone call format");
        } else {
            return strArray;
        }
    }

    @Deprecated
    public PhoneBill parse () {
        return new PhoneBill(new PhoneCall("","","","","","",""));
    }

    /**
     * Parses a text file and returns a the phonebill of that text file
     * @param filelocation string location of that file
     * @return
     */
    public static PhoneBill parse (String filelocation) {

        String thisLine = null;

        List<String []> phoneStringLists = new ArrayList<String []>();

        try {
            FileReader fr = new FileReader(filelocation);
            BufferedReader br = new BufferedReader(fr);

            // Read all lines
            while ((thisLine = br.readLine()) != null) {
                phoneStringLists.add(parseCall(thisLine));
            }
        }
        catch(Exception e) {
            // Return new phonebill if the file reader could not read any file
            return new PhoneBill();
        }

        PhoneBill returnPhoneBill = new PhoneBill();

        try {
            for (String[] phoneCallString : phoneStringLists) {
                returnPhoneBill.addPhoneCall(new PhoneCall(phoneCallString[0], phoneCallString[1], phoneCallString[2], phoneCallString[3], phoneCallString[4], phoneCallString[5], phoneCallString[6]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnPhoneBill;
    }

}