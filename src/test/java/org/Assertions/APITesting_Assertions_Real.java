package org.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import static org.assertj.core.api.Assertions.*;
public class APITesting_Assertions_Real {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;
@Test
    public void test_post(){ // after creating booking we will have booking id which we need to give PUT request
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
        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // There are three libraries for Assertions and we have to choose one.

    //  Rest assured :-validatable response - It is an interface provided by Hamcrest already present in Rest Assured
    //For this we need to import Mtchers from hamcrest as follows
    // import org.hamcrest.Matchers;
    // 2nd library is TestNG Assertions
    // then AssertJ

    validatableResponse.body("booking.firstname",Matchers.equalTo("Mehak"));
    validatableResponse.body("booking.lastname",Matchers.equalTo("Kohli"));
    validatableResponse.body("booking.depositpaid",Matchers.equalTo("false"));
    validatableResponse.body("bookingid",Matchers.notNullValue());
    // Matchers is a library that contains all the values

    // TestNG Assertions
// In this we need to extract the things as follows
    bookingId = response.then().extract().path("bookingid");
    String firstname = response.then().extract().path("booking.firstname");
    String lastname = response.then().extract().path("booking.lastname");
    Assert.assertNotNull(bookingId);// extraction
    Assert.assertEquals(firstname,"Mehak"); // extraction
    Assert.assertEquals(firstname,"Kohli"); // extraction

    // AssertJ ( 3rd - Library to Assertions), we are using this nowadays.
    // For this we need to install the dependency assertj core in mpom.xml from maven repository.
    // Next we need to import static org.assertj.core.api.Assertions.*
// In this case also we need to extract , marked as extraction

    assertThat(bookingId).isNotNull().isPositive().isNotZero();
    assertThat(firstname).isEqualTo("Mehak").isNotBlank().isNotNull().isNotEmpty().isAlphanumeric();

    // Difference between blank and empty
    // String s = ""; // Empty
    // String s = "  " ; // Blank


}}
