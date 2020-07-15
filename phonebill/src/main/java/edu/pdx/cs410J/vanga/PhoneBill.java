package edu.pdx.cs410J.vanga;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhoneBill extends AbstractPhoneBill<PhoneCall> {

    String customer;
    Collection<PhoneCall> calls = new ArrayList<>();

    public PhoneBill(String name) {
        this.customer = name;//caller name
    }

    @Override
    public String getCustomer()
    {
        return this.customer;
    }

    @Override
    public void addPhoneCall(PhoneCall call)
    {

        this.calls.add(call);//adds phone call
    }

    @Override
    public Collection<PhoneCall> getPhoneCalls() {
        return this.calls; //returns phone call as collection
    }

}
