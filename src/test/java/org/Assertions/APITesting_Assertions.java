package org.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_Assertions {

    // TestNG Assertion
    // Assertion means expected result == Actual result
   //Assert is a class present in a TestNG

    @Test
    public void test_hardassertion(){
        System.out.println("Start of the program");
        Assert.assertTrue(true); // if assertion fails then next code will not be executed in hard assertion
        System.out.println("End of the program");

        Assert.assertEquals("Mehak", "Mehak");// Another type of Assertion.
        Assert.assertEquals("Mehak","Kohli");
    }

    @Test
    public void test_softassertion(){
        SoftAssert softassert = new SoftAssert();
        System.out.println("Welcome");
        Assert.assertTrue(false); // next line will always execute even if the assertion is false
        System.out.println("Bye");
        softassert.assertAll(); // This will report all the collected errors.
    }
}
