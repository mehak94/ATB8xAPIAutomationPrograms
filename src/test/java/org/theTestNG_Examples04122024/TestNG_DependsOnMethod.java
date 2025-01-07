package org.theTestNG_Examples04122024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_DependsOnMethod {

        @Test
        public void serverStartedOk(){
            System.out.println("I will run first");
            Assert.assertTrue(false); // we can also write false incase of true if it is true then only
        }// method1 will run.

        @Test(dependsOnMethods = "serverStartedOk")
        public void method1(){
            System.out.println("method1");// we can also add assertion here as we are testing the test cases.
        }
    }

