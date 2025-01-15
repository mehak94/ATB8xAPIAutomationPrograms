package org.theTestNG_Examples04122024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGInvocationCount {
    @Test(invocationCount = 3)
    public void test10(){
        System.out.println("I m running it twice");
        Assert.assertTrue(true);
    }
}
