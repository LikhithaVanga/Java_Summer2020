package edu.pdx.cs410J.vanga;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

  public static void main(String[] args) {

    if (args.length == 0) {
      System.err.println("No arguments!");
      System.exit(1);
    } else if (args.length == 1) {
      System.err.println("Missing Caller number");
      System.exit(1);
    } else if (args.length == 2) {
      System.err.println("Missing Calee number");
      System.exit(1);
    } else if (args.length == 3) {
      System.err.println("Missing call Date");
      System.exit(1);
    } else if (args.length == 4) {
      System.err.println("Missing call start time");
      System.exit(1);
    }else if (args.length == 5) {
      System.err.println("Missing call Date");
      System.exit(1);
    }else if (args.length == 6) {
      System.err.println("Missing call end time");
      System.exit(1);
    }else if (args.length == 7) {
      System.out.println("call from " +args[1] +"to" +args[3]+ "ön" + args[4]);
      System.err.println("Missing print");
      System.exit(1);
    } else if (args.length == 8) {
      if(args[7].equals("-README") || args[7].equals("-readme"))
      {
        readme();
        System.exit(1);
      }
      else{


        if ((args[7].equals("-print") || args[7].equals("-PRINT"))){
          PhoneCall call = new PhoneCall(args[1], args[2], args[3], args[4],args[5], args[6]);
          call.printCaller();
          System.exit(1);
        }
        else{
          System.out.println("Missing command line arguments");
        }

      }
    } else if (args.length > 9) {
      System.err.println("Too many args");
      System.exit(1);

    } else {

      PhoneCall call = new PhoneCall(args[1], args[2], args[3], args[4],args[5], args[6]);// Refer to one of Dave's classes so that we can be sure it is on the classpath
      PhoneBill bill = new PhoneBill(args[0]);

      bill.addPhoneCall(call);

      if ((args[8].equals("-print") || args[8].equals("-PRINT"))){
        call.printCaller();
        System.exit(1);
      }
      else{
        readme();
        //System.out.println("Missing command line arguments");
        System.exit(1);
      }
    }
  }

  public static void readme(){
    System.out.println("Customer is the caller");
    System.out.println("Caller stores the customers phone number");
    System.out.println("Calee stores the recevers phone number");
    System.out.println("Start stores the Date of phone call");
    System.out.println("Stop stores the Date of phone call ended");
    System.out.println("timeStart stores the time of phone call started");
    System.out.println("timeEnd stores the time of phone call ended");
    System.out.println();
  }

}