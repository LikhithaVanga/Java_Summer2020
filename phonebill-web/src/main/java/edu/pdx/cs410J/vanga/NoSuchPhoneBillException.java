package edu.pdx.cs410J.vanga;
/**
        * Custom Exception for when there is no phone bill
        */
public class NoSuchPhoneBillException extends RuntimeException
{
    /**
     * Constructor for NoSuchPhoneBillException
     * @param s
     */
    public NoSuchPhoneBillException(String s)
    {
        super(s);
    }
}