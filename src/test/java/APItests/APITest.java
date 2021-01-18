package APItests;

import data.DataAPI;
import models.PetAddRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest{

    @Test
    public void testAPIGetData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.getCall(8886);
        System.out.println("Here is API data: " + data.name+"  "+data.status+" "+ data.tags[0].name);
        Assert.assertNotEquals(data.name, "Bobik");
    }
    @Test
    public void testAPIPostData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.postCall(8886, "Bobik");
        System.out.println("Here is API data: " + data.name+"  "+ data.category.name+"  "+data.petStatus);
    }
    @Test
    public void testAPIPutData(){
        //DataAPI dataAPI = new DataAPI();
        var data = DataAPI.putCall(10033, "Sharik");
        System.out.println("Here is API data: " + data.name+"  "+ data.category.name+"  "+data.petStatus);
    }
    @Test
    public void testAPIDeleteData(){
        //DataAPI dataAPI = new DataAPI();
        //var data = DataAPI.deleteCall(10033);
        Assert.assertEquals(DataAPI.deleteCall(10033), 200);
    }
    @Test
    public void testAPIOptions(){
        //DataAPI dataAPI = new DataAPI();
        //var data = DataAPI.deleteCall(10033);
        System.out.println(DataAPI.optionsCall());
    }
}
