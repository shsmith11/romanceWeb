package data;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import models.GetPetAPI;
import models.PetAddRequest;
import models.PetAddResponce;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class DataAPI {

    public static GetPetAPI getCall(int id){
        //String basePath = "v2/pet/"+id;
        Response response = given()
                .baseUri("https://petstore.swagger.io/")
                //.header("Authorization","Bearer "+token)
                .basePath("v2/pet")
                .when()
                .get("/"+id)
                .then()
                .statusCode(200)
                //.assertThat().statusCode(200)
                //.assertThat().statusCode(404)
                .extract()
                .response();

        response.getBody().prettyPrint();
        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getObject("$", GetPetAPI.class);
    }

    public static PetAddResponce postCall(int id, String name){
        String[] rules = {};
        var pet = new PetAddRequest(id, name, rules);
        var requestBody = new Gson().toJson(pet);

        Response response = given()
                .baseUri("https://petstore.swagger.io/")
                //.header("Authorization","Bearer "+token)
                .basePath("v2/pet")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.getBody().prettyPrint();
        System.out.println(response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getObject("$", PetAddResponce.class);
    }

    public static PetAddResponce putCall(int id, String name){
        String[] rules = {};
        var pet = new PetAddRequest(id, name, rules);
        var requestBody = new Gson().toJson(pet);

        Response response = given()
                .baseUri("https://petstore.swagger.io/")
                //.header("Authorization","Bearer "+token)
                .basePath("v2/pet")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.getBody().prettyPrint();
        System.out.println(response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getObject("$", PetAddResponce.class);
    }
    public static int deleteCall(int id){

        String basePath = "v2/pet/"+id;
        Response response = given()
                .baseUri("https://petstore.swagger.io/")
                //.header("Authorization","Bearer "+token)
                .basePath(basePath)
                .when()
                .delete()
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.getStatusCode());
        return response.getStatusCode();
    }


}
