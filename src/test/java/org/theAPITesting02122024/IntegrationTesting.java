package org.theAPITesting02122024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static javax.swing.UIManager.getString;

public class IntegrationTesting {

    // Create a token
    // Create a booking
    // Perform a PUT request
    // Verify that PUT is successful by GET request
    // Delete the ID
    //Verify it does not exist by GET request

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingId;

    public String getToken(){// after post request we will have a token which we need to give during PUT request.
        String payload= "{\n"+"\"username\" : \"admin\",\n"+"\"password\":\"password123\"\n"+"}";
       requestSpecification = RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com");
       requestSpecification.basePath("/auth");
       requestSpecification.contentType(ContentType.JSON).log().all();
       requestSpecification.body(payload);
        response = requestSpecification.when().post();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
// To extract the token
        token = response.jsonPath().getString("token");// x.token, x.bookingId, x.booking.firstname
        System.out.println(token);
        return token;
    }
public String getBookingId(){ // after creating booking we will have booking id which we need to give PUT request
    String payload_POST = "{\n" +
            "    \"firstname\" : \"Josh\",\n" + // As it looks clumsy we can convert into class and objects
            "    \"lastname\" : \"Allen\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Superbowls\"\n" +
            "}";
    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.body(payload_POST).log().all();
    response = requestSpecification.when().post();
    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);
// To extract the bookingId
    bookingId = response.jsonPath().getString("bookingid");
    System.out.println("===============");
    System.out.println(bookingId);
    System.out.println("?????????????");
    return bookingId;
}

@Test(priority = 1)
public void test_update_request_put() {
    String token= getToken();
    String bookingId = getBookingId();
    System.out.println(">>>>>>>>>>>>>>");
    System.out.println(token);
    System.out.println(bookingId);
    String payloadPUT = "{\n" +
            "    \"firstname\" : \"Joshith\",\n" + // As it looks clumsy we can convert into class and objects
            "    \"lastname\" : \"Allen\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Superbowls\"\n" +
            "}";
    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
    requestSpecification.basePath("/booking/"+bookingId);
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token",token);
    requestSpecification.body(payloadPUT).log().all();
    response = requestSpecification.when().put();
    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);
}
@Test(priority = 2)
    public void test_update_request_get(){
    System.out.println(bookingId);
    requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
    requestSpecification.basePath("/booking/"+bookingId);
    response = requestSpecification.when().get();
    validatableResponse= response.then().log().all();
    validatableResponse.statusCode(200);
    String firstname = response.jsonPath().getString("firstname");
    Assert.assertEquals(firstname,"Joshith");
}

@Test(priority = 3)
public void test_delete_booking(){
//    String token= getToken();
//        String bookingId=getBookingId();
   System.out.println(bookingId);
    System.out.println(token);
    requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
    requestSpecification.basePath("/booking/"+bookingId);
    requestSpecification.cookie("token",token);
    response = requestSpecification.when().delete();
    validatableResponse= response.then().log().all();
    validatableResponse.statusCode(201);
    //String bookingid = response.jsonPath().getString("bookingid");
}

@Test(priority = 4)
    public void test_after_delete_request_get(){
// String bookingId=getBookingId();
//String token= getToken();
    //System.out.println("9999999999");
     // System.out.println(bookingId);
    //System.out.println(token);
      requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
      requestSpecification.basePath("/booking/"+bookingId);
//      requestSpecification.cookie("token",token);
      response = requestSpecification.when().log().all().get();
      //validatableResponse= response.then().log().all();
      requestSpecification.then().log().all().statusCode(404);
}
}
