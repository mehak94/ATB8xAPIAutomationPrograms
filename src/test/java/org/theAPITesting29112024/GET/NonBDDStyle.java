package org.theAPITesting29112024.GET;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class NonBDDStyle {
    RequestSpecification r = RestAssured.given();
    @Severity(SeverityLevel.BLOCKER)// We have added allure testng in this case and allurecommandline
    @Description("TC1 - NonBDDStyleGET - PositiveTestCase ") // after downloading we will run our program again
    // and will see that allure-results folder will automatically install in our system
    @Test // after this go to terminal and write the command " allure serve allure-results
    public void test_NonBDDStylePositive(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+560066);
        r.when().log().all().get();
        r.then().log().all().statusCode(200); // We can create copy of xml file to run it as well.
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC2 - NonBDDStyleGET - NegativeTestCase ")
    public void test_NonBDDStyleNegative(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+560066);
        r.when().log().all().get();
        r.then().log().all().statusCode(200); // We can create copy of xml file to run it as well.
    }
}
