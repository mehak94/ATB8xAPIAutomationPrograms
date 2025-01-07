package org.theTestNG_Examples04122024;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameter {

@Parameters("browser")
    @Test
    void demo1(String value){
    System.out.println("Browser is " + value);
    if(value.equalsIgnoreCase("Chrome")){
        System.out.println("Start my Testing");
    }
    if(value.equalsIgnoreCase("firefox")){
        System.out.println("Start my firefox");
    }// thus we can use parameters when there are more than two test cases , no need to change the code only we can
}// can create new xml
}
