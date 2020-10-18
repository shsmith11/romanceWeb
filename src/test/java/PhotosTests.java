import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PhotosTests extends BaseTest{

    @Test
    public void isPhotoPage(){
        photosPage.openPage(PagesLinks.photosUrl);
        Assert.assertTrue(photosPage.getPageTitle());
    }

    @Test
    public void isPicturesLoaded(){
        photosPage.openPage(PagesLinks.photosUrl);
        Assert.assertTrue(photosPage.loadAlbymPictures());
    }
}
