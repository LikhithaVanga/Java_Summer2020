package edu.pdx.cs410J.vanga;

public class PhoneBillRestException extends RuntimeException {
    public PhoneBillRestException(int httpStatusCode)
    {
        super("Got an HTTP Status Code of " + httpStatusCode);
    }
}
