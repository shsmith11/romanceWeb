import data.DataAPI;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void testAPIGetData(){
        //DataAPI dataAPI = new DataAPI();

        var data = DataAPI.getCall();
        System.out.println("Here is API data: " + data.name);
    }
}
