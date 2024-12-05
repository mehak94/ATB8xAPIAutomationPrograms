package org.theAPITesting29112024.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BDDStyleGET {

        @Test
        public void BDDStyleGET_Positive(){
            String pin_code = "560066";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pin_code)
                    .when()
                    .log()
                    .all()
                    .get()
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    @Test
    public void BDDStyleGET_Negative(){
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }






    }


