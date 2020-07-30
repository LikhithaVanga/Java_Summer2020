package edu.pdx.cs410J.vanga;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import static edu.pdx.cs410J.vanga.PhoneBillServlet.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
/**
 * A unit test for the {@link PhoneBillServlet}.  It uses mockito to
 * provide mock http requests and responses.
 */

  public class PhoneBillServletTest
  {
    @Test
    public void initiallyServletContainsNoPhoneBills() throws ServletException, IOException
    {
      PhoneBillServlet servlet = new PhoneBillServlet();

      HttpServletRequest mockRequest = mock(HttpServletRequest.class);
      HttpServletResponse mockResponse = mock(HttpServletResponse.class);
      PrintWriter mockPrintWriter = mock(PrintWriter.class);

      when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

      when(mockRequest.getParameter(CUSTOMER_PARAMETER)).thenReturn("Customer");

      servlet.doGet(mockRequest, mockResponse);

      //verify(mockResponse).setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Ignore
    @Test
    public void addPhoneBill() throws ServletException, IOException
    {
      PhoneBillServlet servlet = new PhoneBillServlet();

      String customer = "Customer";
      String caller = "123-456-8901";
      String callee = "234-567-1234";
      String startTime = "9/20/2018 7:15 AM";
      String endTime = "9/20/2018 7:30 AM";

      HttpServletRequest mockRequest = mock(HttpServletRequest.class);
      when(mockRequest.getParameter("customer")).thenReturn(customer);
      when(mockRequest.getParameter("caller")).thenReturn(caller);
      when(mockRequest.getParameter("callee")).thenReturn(callee);
      when(mockRequest.getParameter("start")).thenReturn(startTime);
      when(mockRequest.getParameter("end")).thenReturn(endTime);

      HttpServletResponse mockResponse = mock(HttpServletResponse.class);
      PrintWriter mockPrintWriter = mock(PrintWriter.class);

      when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

      servlet.doPost(mockRequest, mockResponse);

      verify(mockResponse).setStatus(HttpServletResponse.SC_OK);

      PhoneBill bill = servlet.getPhoneBill(customer);
      assertThat(bill, not(nullValue()));
      assertThat(bill.getCustomer(), equalTo(customer));

      Collection<PhoneCall> calls = bill.getPhoneCalls();
      assertThat(calls.size(), equalTo(1));

      PhoneCall call = calls.iterator().next();
      assertThat(call.getCaller(), equalTo(caller));
      assertThat(call.getCallee(), equalTo(callee));
      assertThat(call.getStartTime(), equalTo(new Date(startTime)));
      assertThat(call.getEndTime(), equalTo(new Date(endTime)));
    }

    @Test
    public void getReturnsPrettyPhoneBill() throws IOException, ServletException
    {
      PhoneBillServlet servlet = new PhoneBillServlet();

      String customer = "Customer";
      String callerNumber = "123-456-7890";
      String calleeNumber = "234-567-8901";
      String start = "9/20/2018 7:15 AM";
      String end = "9/20/2018 7:30 AM";

      PhoneBill bill = new PhoneBill(customer);
      PhoneCall call = new PhoneCall(callerNumber, calleeNumber, start, end);
      bill.addPhoneCall(call);
      servlet.addPhoneBill(bill);

      HttpServletRequest mockRequest = mock(HttpServletRequest.class);
      HttpServletResponse mockResponse = mock(HttpServletResponse.class);
      PrintWriter mockPrintWriter = mock(PrintWriter.class);

      when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

      when(mockRequest.getParameter(CUSTOMER_PARAMETER)).thenReturn("Customer");

      servlet.doGet(mockRequest, mockResponse);

      verify(mockResponse).setStatus(HttpServletResponse.SC_OK);
      verify(mockPrintWriter).println(customer);
      //  verify(mockPrintWriter).println(call.toString());
    }

    @Test
    public void getDumpSearch() throws IOException, ServletException
    {
      PhoneBillServlet servlet = new PhoneBillServlet();

      String customer = "Customer";
      String callerNumber = "123-456-7890";
      String calleeNumber = "234-567-8901";
      String start = "9/20/2018 7:15 AM";
      String end = "9/20/2018 7:30 AM";

      PhoneBill bill = new PhoneBill(customer);
      PhoneCall call = new PhoneCall(callerNumber, calleeNumber, start, end);
      bill.addPhoneCall(call);
      servlet.addPhoneBill(bill);

      HttpServletRequest mockRequest = mock(HttpServletRequest.class);
      HttpServletResponse mockResponse = mock(HttpServletResponse.class);
      PrintWriter mockPrintWriter = mock(PrintWriter.class);

      when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

      when(mockRequest.getParameter(CUSTOMER_PARAMETER)).thenReturn("Customer");
      when(mockRequest.getParameter(START_TIME_PARAMETER)).thenReturn("9/20/2018 7:10 AM");
      when(mockRequest.getParameter(END_TIME_PARAMETER)).thenReturn("9/20/2018 7:10 AM");

      servlet.doGet(mockRequest, mockResponse);

      verify(mockResponse).setStatus(HttpServletResponse.SC_OK);
      verify(mockPrintWriter).println(customer);
      //  verify(mockPrintWriter).println(call.toString());
    }

    @Test
    public void getReturnsPrettyPhoneBillWithinRange() throws IOException, ServletException, ParseException, ParseException {
      PhoneBillServlet servlet = new PhoneBillServlet();

      String customer = "Customer";
      PhoneBill bill = new PhoneBill(customer);
      String start1 = "01/27/2018 8:56 am";
      String end1 = "02/27/2018 10:27 am";

      String start2 = "02/02/2018 9:00 am";
      String end2 = "02/20/2018 10:00 pm";

      String start3 = "02/10/2018 10:00 pm";
      String end3 = "02/15/2018 6:00 am";

      String startRange = "02/01/2018 6:00 am";
      String endRange = "02/21/2018 10:00 pm";



      PhoneCall call1 = new PhoneCall("123-456-7890", "234-456-6789", start1, end1);
      PhoneCall call2 = new PhoneCall("123-456-7890", "234-456-6789", start2, end2);
      PhoneCall call3 = new PhoneCall("123-456-7890", "234-456-6789", start3, end3);
      bill.addPhoneCall(call1);
      bill.addPhoneCall(call2);
      bill.addPhoneCall(call3);
      servlet.addPhoneBill(bill);

      HttpServletRequest mockRequest = mock(HttpServletRequest.class);
      HttpServletResponse mockResponse = mock(HttpServletResponse.class);
      PrintWriter mockPrintWriter = mock(PrintWriter.class);

      when(mockResponse.getWriter()).thenReturn(mockPrintWriter);

      when(mockRequest.getParameter(CUSTOMER_PARAMETER)).thenReturn("Customer");
      when(mockRequest.getParameter(START_TIME_PARAMETER)).thenReturn(startRange);
      when(mockRequest.getParameter(END_TIME_PARAMETER)).thenReturn(endRange);

      servlet.doGet(mockRequest, mockResponse);

      verify(mockResponse).setStatus(HttpServletResponse.SC_OK);
      verify(mockPrintWriter).println(customer);
      //verify(mockPrintWriter, never()).println(call1.toString());
      //verify(mockPrintWriter).println(call2.toString());
      //verify(mockPrintWriter).println(call3.toString());
    }

  }