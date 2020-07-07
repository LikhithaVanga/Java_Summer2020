package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class PhoneCall extends AbstractPhoneCall {

  private final String Start_time;
  private final String End_time;

  private String Caller;
  private String Callee;
  private String Start;
  private String Stop;

  Pattern PhnNumPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

  public PhoneCall(String callerNum, String calleeNum, String start, String StartTime, String stop, String EndTime){
    this.Caller = validatePhnNumber(callerNum);
    this.Callee = validatePhnNumber(calleeNum);
    this.Start = validateDate(start);
    this.Stop = validateDate(stop);
    this.Start_time = StartTime;
    this.End_time = EndTime;
  }



  private String validatePhnNumber(String input){
    var matcher = PhnNumPattern.matcher(input);

    if (!matcher.matches()) {
      System.out.println("Invalid phone number: " + input);
      return "Invalid Number";
    }
    else{
      return input;
    }

  }

  public static String validateDate(String strtDate)
  {
    //check if date is null
    if (strtDate.trim().equals(""))
    {
      return "";
    }
    else
    {
      SimpleDateFormat strtdateFormat = new SimpleDateFormat("dd/MM/yyyy");
      strtdateFormat.setLenient(false);
      try
      {
        Date javaDate = strtdateFormat.parse(strtDate);
      }
      /* Given Date format is invalid */
      catch (ParseException e)
      {
        System.out.println(strtDate+" is not a valid date format");
        return "";
      }
      return strtDate;
    }
  }


  @Override
  public String getCaller() {
    return Caller;
    //throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getCallee() {
    return Callee;
    //return "This method is not implemented yet";
  }

  @Override
  public String getStartTimeString() {
    return End_time;
    //throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getEndTimeString() {
    return Start_time;
    //throw new UnsupportedOperationException("This method is not implemented yet");
  }

  public void printCaller()
  {
    if(this.Caller != "Invalid ###" && this.Callee != "Invalid ###")
      System.out.println(toString());
  }



}
