package org.theTestNG_Examples04122024;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITestingTestNGAnnotations {
@BeforeTest
public void get_token(){
    System.out.println("1");
}
@BeforeTest// Annotation added
public void get_booking_id(){
    System.out.println("2");
}
@Test
public void APITestingTestNG_PUT(){
    System.out.println("3");
}
// This is called annotations, order doesnot matter in it
}
