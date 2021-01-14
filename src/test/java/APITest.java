import data.DataAPI;
import models.PetAddRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest {

    @Test
    public void testAPIGetData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.getCall(10033);
        System.out.println("Here is API data: " + data.name+"  "+data.status);
        Assert.assertNotEquals(data.name, "Bobik");
    }
    @Test
    public void testAPIPostData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.postCall(10033, "Bobik");
        System.out.println("Here is API data: " + data.name+"  "+ data.category.name+"  "+data.petStatus);
    }
    @Test
    public void testAPIPutData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.putCall(10033, "Sobaka");
        System.out.println("Here is API data: " + data.name+"  "+ data.category.name+"  "+data.petStatus);
    }
    @Test
    public void testAPIDeleteData(){
        //DataAPI dataAPI = new DataAPI();
        //var data = DataAPI.deleteCall(10033);
        Assert.assertEquals(DataAPI.deleteCall(10033), 200);
    }
}
