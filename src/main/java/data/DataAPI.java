package data;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import models.GetPetAPI;

import static io.restassured.RestAssured.given;

public class DataAPI {

    public static GetPetAPI getCall(){

        Response response = given()
                .baseUri("https://petstore.swagger.io/")
                //.header("Authorization","Bearer "+token)
                .basePath("v2/pet/12")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.getBody().prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getObject("$", GetPetAPI.class);
    }
}
