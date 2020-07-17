package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.Collection;
import java.util.*;

public class PhoneBill extends AbstractPhoneBill<PhoneCall> {

    private String customer;
    private List<PhoneCall> callList;

    public PhoneBill () {
        callList = new ArrayList<PhoneCall>();
        customer = "";
    }

    public PhoneBill (PhoneCall initial) {
        customer = initial.getCustomer();
        callList = new ArrayList<PhoneCall>();
        callList.add(initial);
    }

    /**
     * Method to return the customer from a phone bill
     * @return customer string
     */
    @Override
    public String getCustomer() {
        return customer;
    }

    /**
     * Adds a phone call to a phone bill
     * @param phoneCall
     */
    @Override
    public void addPhoneCall(PhoneCall phoneCall) {
        if(customer.equals("")) {
            customer = phoneCall.getCustomer();
        }
        callList.add(phoneCall);
    }

    /**
     * Returns the list of phone calls in a phone bill
     * @return callList
     */
    @Override
    public Collection<PhoneCall> getPhoneCalls() {
        return callList;
    }

    /**
     * Returns
     * @param o
     * @return Whether two phone bills are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneBill)) return false;
        PhoneBill phoneBill = (PhoneBill) o;
        return getCustomer().equals(phoneBill.getCustomer()) &&
                callList.equals(phoneBill.callList);
    }
}