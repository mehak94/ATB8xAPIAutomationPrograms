package org.theTestNG_Examples04122024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_AlwaysRun {

    @Test
    public void test01(){
        System.out.println(1);
        Assert.assertTrue(true);
    }
    @Test(alwaysRun = true) // means this will always execute.
    public void test02(){ //even if depends onMethods is fail.
        System.out.println(2);
        Assert.assertTrue(true);
    }
    @Test
    public void test03() {
        System.out.println(3);
        Assert.assertTrue(true);
    }}

