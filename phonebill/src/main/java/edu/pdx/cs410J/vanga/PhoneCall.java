package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import static java.time.format.DateTimeFormatter.ofPattern;

public class PhoneCall<pattern, TIME12HOURS_PATTERN> extends AbstractPhoneCall {
  private final String Start_time;
  private final String End_time;
  /**
   * Stores the caller's phone number in the format xxx-xxx-xxxx.
   */
  private String Caller;
  /**
   * Stores the callee's phone number in the format xxx-xxx-xxxx.
   */
  private String Callee;
  /**
   * Stores the start date and time of the phone call in the format MM/dd/yyyy hh:mm (am/pm).
   */
  private String Start;
  /**
   * Stores the end date and time of the phone call in the format MM/dd/yyyy hh:mm (am/pm).
   */
  private String Stop;

  /**
   * Phone number pattern
   */
  public static final Pattern NumPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");


  /**
   * constructor
   * @param callerNum
   * @param calleeNum
   * @param start
   * @param timeStart
   * @param stop
   * @param timeEnd
   */
  public PhoneCall(String callerNum, String calleeNum, String start, String timeStart, String stop, String timeEnd){
    this.Caller = validateNumber(callerNum);
    this.Callee = validateNumber(calleeNum);
    this.Start = validateJavaDate(start);
    this.Stop = validateJavaDate(stop);
    this.Start_time = timeStart;
    this.End_time = timeEnd;

  }

  /**
   *
   * @param input the phone number
   * @return the phone number if in correct format or returns Invalid number
   */
  private String validateNumber(String input){
    var matcher = NumPattern.matcher(input);

    if (!matcher.matches()) {
      System.out.println("Invalid phone number: " + input);
      return "Invalid ###";
    }
    else{
      return input;
    }

  }

  /**
   *
   * @param strDate the date call was initiated
   * @return returns date if in correct format or null in incorrect
   */
  public static String validateJavaDate(String strDate)
  {
    /* Check if date is 'null' */
    if (strDate.trim().equals(""))
    {
      return "";
    }
    /* Date is not 'null' */
    else
    {
      SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
      sdfrmt.setLenient(false);
      try
      {
        Date javaDate = sdfrmt.parse(strDate);
      }
      /* Date format is invalid */
      catch (ParseException e)
      {
        System.out.println(strDate+" is Invalid Date format");
        return "Invalid Date format";
      }
      return strDate;
    }
  }

  /**
   *
   * @return returns the caller number
   */
  @Override
  public String getCaller()
  {
    return Caller;
    //throw new UnsupportedOperationException("This method is not implemented yet");
  }

  /**
   *
   * @return the calee phone number
   */
  @Override
  public String getCallee()
  {
    return Callee;
  }

  /**
   *
   * @return the concatinated start date and time call was made
   */
  @Override
  public String getStartTimeString()
  {
    if(this.Start == "" || this.Start_time == "")
    {
      throw new UnsupportedOperationException("Invalid Date format");
    }
    else{
      return Start.concat(" ").concat(Start_time);
    }
  }

  /**
   *
   * @return the concatinated end date and time call was made
   */
  @Override
  public String getEndTimeString()
  {
    return Stop.concat(" ").concat(End_time);
  }

  /**
   * Prints call details to screen
   */
  public void printCaller()
  {
    if(this.Caller != "Invalid ###" && this.Callee != "Invalid ###")
      System.out.println(toString());
  }

}