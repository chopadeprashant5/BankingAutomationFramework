package api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetCustomerAPI extends BaseAPI {

    @Test
    public void getUserDetails() {

        setup();

        Response response =

        given()
        .when()
            .get("/users/1")
        .then()
            .extract().response();

        System.out.println(response.asString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}