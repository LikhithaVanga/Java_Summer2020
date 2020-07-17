package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {

  private String customer;
  private String caller;
  private String callee;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;

  public PhoneCall (String customer, String caller, String callee, String startDate, String startTime, String endDate, String endTime) {
    this.customer = customer;
    this.caller = caller;
    this.callee = callee;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
  }

  /**
   * Get the caller information
   * @return caller
   */
  @Override
  public String getCaller() {
    return caller;
  }

  /**
   * Gets the callee information
   * @return callee
   */
  @Override
  public String getCallee() {
    return callee;
  }

  /**
   * Gets the start time string
   * @return start time string
   */
  @Override
  public String getStartTimeString()  {
    return startDate + " " + startTime;
  }

  /**
   * Gets the end time string
   * @return end time string
   */
  @Override
  public String getEndTimeString()  {
    return endDate + " " + endTime;
  }


  public String printInfo()  {
    return customer + " " + caller + " " + callee + " " + startDate + " " + startTime + " " + endDate + " " + endTime;
  }

  /**
   * Gets the customer string
   * @return customer
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * Defines equality for two phone calls. They are equal if all fields are equal.
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PhoneCall)) return false;

    PhoneCall phoneCall = (PhoneCall) o;

    if (!getCustomer().equals(phoneCall.getCustomer())) return false;
    if (!getCaller().equals(phoneCall.getCaller())) return false;
    if (!getCallee().equals(phoneCall.getCallee())) return false;
    if (!getStartTimeString().equals(phoneCall.getStartTimeString())) return false;
    return getEndTimeString().equals(phoneCall.getEndTimeString());
  }

}