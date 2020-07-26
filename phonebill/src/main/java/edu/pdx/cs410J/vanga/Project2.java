<<<<<<< HEAD
//package edu.pdx.cs410J.vanga;
//
//import java.util.ArrayList;
//
//public class Project2 {
//  /**
//   * Readme method that prints a readme based on user input
//   */
//  public static void printReadme () {
//    System.out.println();
//    System.out.println("Customer is the caller");
//    System.out.println("Caller stores the customers phone number");
//    System.out.println("Calee stores the recevers phone number");
//    System.out.println("Start stores the Date of phone call");
//    System.out.println("Stop stores the Date of phone call ended");
//    System.out.println("timeStart stores the time of phone call started");
//    System.out.println("timeEnd stores the time of phone call ended");
//    System.out.println();
//  }
//
//  /**
//   * Main
//   * @param args
//   * */
//  public static void main(String[] args){
//
//    int filePosition = 0;
//
//    // Checks if the command line input is less than seven. If it's just a readme, print the readme. Else throw an exception.
//    if(args.length < 7) {
//      if(args.length == 1 && args[0].equals( "-README")) {
//        printReadme();
//        return;
//      } else {
//        System.out.println("Too Few Arguments");
//      }
//
//      System.out.println("Too Few Arguments");
//      // Checks if the arguments are too long
//    } else if (args.length > 11) {
//      throw new IllegalArgumentException("Too Many Arguments");
//    }
//    if(args.length == 0) {
//      System.out.println("No arguments");
//    }
//
//
//    int numOptions = 0;
//    ArrayList<String> optionsArray = new ArrayList<String>();
//
//    for (int i = 0; i < args.length - 7; i++) {
//      String value = args[i];
//      if(value.equals("-print") || value.equals("-README")) {
//        optionsArray.add(value);
//        numOptions++;
//      } else if (value.equals("-textFile")) {
//        optionsArray.add(value);
//        optionsArray.add(args[i+1]);
//        i += 1;
//        filePosition = i;
//        numOptions+=2;
//      } else {
//        throw new IllegalArgumentException("Only arguments allowed are -textFile, -print, -README");
//      }
//    }
//
//    // Gets the data for the phone call and stores it in a data array, checking for format along the way
//    ArrayList<String> dataArray = new ArrayList<String>();
//
//    // Checks to make sure phones, dates, and times are in the right format
//    for (int i = 0; i < 7; i++) {
//      if((i == 1 || i == 2) && !(args[i + numOptions].matches("^\\d{3}-\\d{3}-\\d{4}$"))) {
//        throw new IllegalArgumentException("Phone numbers must be in XXX-XXX-XXXX format");
//      } else if((i == 3 || i == 5) && !(args[i + numOptions].matches("^\\d{1,2}/\\d{1,2}/\\d{4}$"))) {
//        throw new IllegalArgumentException("Dates must be in mm/dd/yyyy format");
//      } else if((i == 4 || i == 6) && !(args[i + numOptions].matches("^\\d{2}:\\d{2}"))) {
//        throw new IllegalArgumentException("Time must be in hh:mm format");
//      }
//    }
//
//    for (int i = 0; i < 7; i++) {
//      dataArray.add(args[i+numOptions]);
//    }
//
//    // Creates the new phone calls and phone bills and executes selected options
//    PhoneCall returnCall = new PhoneCall(args[0 + numOptions],args[1 + numOptions],args[2 + numOptions],args[3 + numOptions],args[4 + numOptions],args[5 + numOptions],args[6 + numOptions]);
//
//
//    // For loop that drives the right action
//    for(int i = 0; i < optionsArray.size();i++) {
//      if(optionsArray.get(i).equals("-print")) {
//        System.out.println(returnCall.toString());
//      } else if (optionsArray.get(i).equals("-README")) {
//        printReadme();
//      } else if (optionsArray.get(i).equals("-textFile")) {
//        i++;
//        PhoneBill returnBill;
//        if(filePosition != 0) {
//          returnBill = TextParser.parse(args[filePosition]);
//        } else {
//          returnBill = new PhoneBill();
//        }
//
//        returnBill.addPhoneCall(returnCall);
//
//        if(filePosition != 0) {
//          TextDumper.dump(returnBill,args[filePosition]);
//        }
//
//      }
//    }
//  }
//}
=======
//package edu.pdx.cs410J.vanga;
//
//import java.util.ArrayList;
//
//public class Project2 {
//  /**
//   * Readme method that prints a readme based on user input
//   */
// 
//}
>>>>>>> 7812b07bb80f8aa65cab6e4840571bac2de7a984
