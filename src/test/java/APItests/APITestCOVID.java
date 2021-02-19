package APItests;

import data.APIInformerCovid;
import io.restassured.path.json.JsonPath;
import models.APICovidInformer.InformerCovidAPI;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITestCOVID {

    @Test
    public void testAPIGetData(){
        //DataAPI dataAPI = new DataAPI();
        var responceData = APIInformerCovid.getAllCountryCall();
        JsonPath jsonPath = APIInformerCovid.getJsonFromResponce(responceData);
        System.out.println("Here is API data: " + APIInformerCovid.getTotalCasesAPI(jsonPath));
        Assert.assertEquals(200,APIInformerCovid.getServerCodeResponce(responceData));
    }
    @Parameters({"country"})
    @Test
    public void testAPIGetCountryData(@Optional("All") String country){
        //DataAPI dataAPI = new DataAPI();
        var responceData = APIInformerCovid.getCountryCall(country);
        JsonPath jsonPath = APIInformerCovid.getJsonFromResponce(responceData);
       // InformerCovidAPI info = APIInformerCovid.getFullAPIJSONresponce(jsonPath);
        System.out.println("Here is API data: " + APIInformerCovid.getStringElementAPI(jsonPath));
        Assert.assertTrue(APIInformerCovid.getStringElementAPI(jsonPath)!=null);
    }
    @Test
    public void getCountryCallTotalCasesATString(){
        Integer responseString = APIInformerCovid.getCountryCallTotalCases("All");
        System.out.println("Total World cases: " + responseString);
    }
}
