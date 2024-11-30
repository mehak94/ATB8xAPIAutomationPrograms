package org.theAPITesting;
import io.restassured.RestAssured;
public class Lab002usingRestAssured {
    public static void main(String[] args) {

        // Gherkins Syntax

        // Full URL :- https://restful-booker.herokuapp.com/booking/1
        // Base URI :- https://restful-booker.herokuapp.com
        // Base Path :- /booking/1

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1")
                .when()
                .get()
                .then().log().all()
                .statusCode(200);

    }// For success it doesnot gives anything but only for failures it will show error
    // If we want to see the details then we will use .log().all()
}
