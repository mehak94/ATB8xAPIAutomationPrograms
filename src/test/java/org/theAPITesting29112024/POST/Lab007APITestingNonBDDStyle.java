package org.theAPITesting29112024.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Lab007APITestingNonBDDStyle {
    @Description("Verify the POST  Request - BDD Syle")
    @Test
    public void test_post_BDDStyle(){
        String payload = "{\n"+ "\"username\" : \"admin\", \n " + "\"password\" : \"password123\"\n" + "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all();
                r.body(payload);
                r.when().post();
                r.then().log().all().statusCode(200);

    }

}

