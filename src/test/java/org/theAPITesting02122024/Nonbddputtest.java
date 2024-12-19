package org.theAPITesting02122024;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class Nonbddputtest {
    // baseuri :  https://restful-booker.herokuapp.com/    // basepath : booking/2684
    //booking id 2684
    //payload = {
    //    "firstname" : "Jim",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
    // cookie : token eecee6a7036cd13

    //request put for update
    //post for booking id
    //post create auth
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;


    @Test
    public void test_put_positive_tc(){
        String booking_id =  "5028";
        String token = "51df0ad244635c6";
        String payloadput = "{\n" +
                "    \"firstname\" : \"news\",\n" +
                "    \"lastname\" : \"testings\",\n" +
                "    \"totalprice\" : 1112,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"lun\"\n" +
                "}";
        //given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+booking_id);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadput).log().all();

        //when
        response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }
}


