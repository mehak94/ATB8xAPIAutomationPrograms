package org.theTestNG_Examples04122024;

import org.testng.annotations.Test;

public class TestNGPriority {

 @Test(priority =1)
    public void TC1(){
     System.out.println("1");
 }
 @Test(priority = 3)
  public void TC2(){
      System.out.println("3");// If we do not give priority then it is alphanumeric order
  }
 @Test(priority = 2)// Priority is helpful to tell us in which order we want to run the testcases
 public void TC3(){// Max we can write 10-12 testcases in single class
     System.out.println("2");
 }


}
