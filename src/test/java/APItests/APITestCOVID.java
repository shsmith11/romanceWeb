package APItests;

import data.APIInformerCovid;
import org.testng.annotations.Test;

public class APITestCOVID {

    @Test
    public void testAPIGetData(){
        //DataAPI dataAPI = new DataAPI();
        var responceData = APIInformerCovid.getAllCountryCall();
        System.out.println("Here is API data: " + APIInformerCovid.getTotalCasesAPI(responceData));
    }
    @Test
    public void testAPIGetCountryData(){
        //DataAPI dataAPI = new DataAPI();
        var responceData = APIInformerCovid.getCountryCall("All");
        APIInformerCovid.getFullAPIresponce(responceData);

        System.out.println("Here is API data: " + APIInformerCovid.getStringElementAPI(responceData));
        //System.out.println("Here is API data: " + APIInformerCovid.getTotalCasesAPI(data));
    }
}
