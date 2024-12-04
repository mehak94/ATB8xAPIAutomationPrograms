package org.theAPITesting29112024;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {
    RequestSpecification r = RestAssured.given();
    @Test
    public void test_NonBDDStylePositive(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+560066);
        r.when().log().all().get();
        r.then().log().all().statusCode(200); // We can create copy of xml file to run it as well.
    }
    @Test
    public void test_NonBDDStyleNegative(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+560066);
        r.when().log().all().get();
        r.then().log().all().statusCode(200); // We can create copy of xml file to run it as well.
    }
}
