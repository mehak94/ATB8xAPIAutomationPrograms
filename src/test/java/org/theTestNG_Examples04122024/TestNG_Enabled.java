package org.theTestNG_Examples04122024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Enabled {

    @Test
    public void test01(){
        System.out.println(1);
        Assert.assertTrue(true);
    }
    @Test(enabled = false) // means skip this , it will not execute.
    public void test02(){ // if it is true then it will execute
        System.out.println(2);
        Assert.assertTrue(true);
}
    @Test
    public void test03() {
        System.out.println(3);
        Assert.assertTrue(true);
    }}