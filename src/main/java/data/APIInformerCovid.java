package data;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.APICovidInformer.InformerCovidAPI;
import models.APICovidInformer.InformerCovidAllAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIInformerCovid {

    public static JsonPath getCountryCall(String country){ /* country name or All for all country statistics*/
        Response response =
            given()
                .baseUri("https://covid-193.p.rapidapi.com")
                .header("x-rapidapi-key","dd66c9131emsh04e2031dfc74d8ap1e6be1jsn60baea46aade")
                .header("x-rapidapi-host","covid-193.p.rapidapi.com")
                .param("country", country) /* country name or All for all country statistics*/
                .basePath("/statistics")
                .contentType(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(200)
                .extract()
                .response();

        response.getBody().prettyPrint();
        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        System.out.println("Date -  "+response.getHeader("Date"));
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;
    }

    public static JsonPath getAllCountryCall(){
        Response response =
            given()
                .baseUri("https://covid-193.p.rapidapi.com")
                .header("x-rapidapi-key","dd66c9131emsh04e2031dfc74d8ap1e6be1jsn60baea46aade")
                .header("x-rapidapi-host","covid-193.p.rapidapi.com")
                .basePath("/statistics")
                .contentType(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(200)
                .extract()
                .response();

        //response.getBody().prettyPrint();
        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        System.out.println("Date -  "+response.getHeader("Date"));
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;

    }
    public static String getStringElementAPI(JsonPath jsonPath){
        String newItemCases;
        return  newItemCases = jsonPath.getString("response.cases.total");
    }

    public static InformerCovidAPI getFullAPIresponce(JsonPath jsonPath){
        return jsonPath.getObject("$", InformerCovidAPI.class);
    }
    public static InformerCovidAllAPI getFullAPIResponceAllCountry(JsonPath jsonPath){
        return jsonPath.getObject("$", InformerCovidAllAPI.class);
    }
    public static Integer getTotalCasesAPI(JsonPath jsonPath){
        Integer totalCases=0;
        HashMap<String,Integer> casesHash = new HashMap<>();
        List<Integer> cases = jsonPath.getList("response.cases.total");
        List<String> countrys = jsonPath.getList("response.country");

        for (int i = 0; i < countrys.size(); i++) {
            casesHash.put(countrys.get(i),cases.get(i));
        }
        List<String> sorted = new ArrayList<>(casesHash.keySet());
        Collections.sort(sorted);
        for (String countreys: sorted) {
            System.out.println(countreys +" - " + casesHash.get(countreys));
        }
        //System.out.println("World total: " + cases);

        return totalCases=casesHash.get("All");
    }

}
