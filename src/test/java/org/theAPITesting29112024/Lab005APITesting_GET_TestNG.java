package org.theAPITesting29112024;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab005APITesting_GET_TestNG {

    // How TestNG works?

   @Test // in place of main function we need to add @Test
    public void test_GET_Request(){ // public void test and its name
       RestAssured
               .given()
               .baseUri("https://restful-booker.herokuapp.com")
               .basePath("/booking/1")
               .when()
               .get()
               .then().log().all()
               .statusCode(200); // To run this we need to create TestNG.xml from settings of intellij we install it.

       // Automation framework we are using is hybrid, framework we are using is Testing framework i.e. TestNG,
       // Rest Assured we are using for HTTP requests.
   }


}
