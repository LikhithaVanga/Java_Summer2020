// package edu.pdx.cs410J.vanga;

// import edu.pdx.cs410J.InvokeMainTestCase;
// import org.junit.Test;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.equalTo;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.CoreMatchers.*;
// import static org.hamcrest.MatcherAssert.*;

// public class Project2IT extends InvokeMainTestCase{

//     /**
//      * Invokes the main method of {@link Project2} with the given arguments.
//      */
//     private InvokeMainTestCase.MainMethodResult invokeMain(String... args) {
//         return invokeMain( Project2.class, args );
//     }


//     @Test
//     public void onlyReadmeOptions () {
//         InvokeMainTestCase.MainMethodResult result = invokeMain( "-README");
//         assertThat(result.getTextWrittenToStandardOut(), not(containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59")));
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
//     }


//     @Test
//     public void oneOptions () {
//         InvokeMainTestCase.MainMethodResult result = invokeMain( "-README", "Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59");
//         assertThat(result.getTextWrittenToStandardOut(), not(containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59")));
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
//     }

//     /**
//      * Checks to ensure that two options work properly
//      */
//     @Test
//     public void twoOptions () {
//         InvokeMainTestCase.MainMethodResult result = invokeMain("-print", "-README", "Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59");
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59"));
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
//     }

//     /**
//      * Checks to ensure that three options working properly
//      */
//     @Test
//     public void threeOptions () {
//         PhoneBill preRunPB = TextParser.parse("likhi.txt");
//         InvokeMainTestCase.MainMethodResult result = invokeMain("-print",  "-textFile", "PhoneBill4.txt", "-README" , "Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59");
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59"));

//         preRunPB.addPhoneCall(new PhoneCall("Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59" ));
//         //assertThat(preRunPB, equalTo(TextParser.parse("likhi.txt")));
//     }

//     /**
//      * Checks to ensure that three options working properly
//      */
//     @Test
//     public void threeOptionsB () {
//         PhoneBill preRunPB = TextParser.parse("phbill.txt");
//         InvokeMainTestCase.MainMethodResult result = invokeMain( "-textFile", "PhoneBill4.txt", "-README", "-print" , "Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59");
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59"));
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
//         preRunPB.addPhoneCall(new PhoneCall("Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59" ));

//     }

//     /**
//      * Checks to make sure that a non text file still works
//      */
//     @Test
//     public void noTXT () {
//         PhoneBill preRunPB = TextParser.parse("PhoneBill10.txt");
//         InvokeMainTestCase.MainMethodResult result = invokeMain( "-textFile", "PhoneBill10.txt", "-README", "-print" , "Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59");
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-440-2707 to 503-645-3231 from 1/15/2015 23:44 to 1/15/2015 23:59"));
//         assertThat(result.getTextWrittenToStandardOut(), containsString("Customer is the caller"));
//         preRunPB.addPhoneCall(new PhoneCall("Likhi","503-440-2707","503-645-3231","1/15/2015","23:44","1/15/2015","23:59" ));
//         assertThat(preRunPB, equalTo(TextParser.parse("PhoneBill10.txt")));
//     }
// }
