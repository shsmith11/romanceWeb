import org.testng.Assert;
import org.testng.annotations.Test;


public class PhotosTests extends BaseTest{


    @Test
    public void isPhotoPage(){
        Assert.assertTrue(photosPage.getPageTitle());
    }

    @Test
    public void isPicturesLoaded(){
        Assert.assertTrue(photosPage.loadAlbymPictures());
    }
}
