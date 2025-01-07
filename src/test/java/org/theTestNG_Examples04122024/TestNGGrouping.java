package org.theTestNG_Examples04122024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGGrouping {

    @Test(groups = {"sanity","qa","preprod"})
        public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
        }

     @Test(groups = {"qa","preprod","reg"})
    public void RegRun(){
         System.out.println("Reg");
         Assert.assertTrue(true);
     }

     @Test(groups = {"dev","stage"})
    public void SmokeRun(){
         System.out.println("Smoke");
     }

     @Test(groups = { "sanity", "qa", "preprod"})
    public void sanityRun1(){
         System.out.println("Sanity");
         System.out.println("QA");
         Assert.assertTrue(true); // if we want to run reg command then we can also create copy of
     } // testNG reg file

     @Test(groups = {"qa","preprod","reg"})
    public void RegRun2(){
         System.out.println("Reg");
         Assert.assertTrue(false);
     }

     @Test(groups = {"dev","stage"})
    public void SmokeRun3(){
         System.out.println("Smoke");
         Assert.assertTrue(false);
     }
    }

