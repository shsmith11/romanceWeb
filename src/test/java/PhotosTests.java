import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PhotosTests extends BaseTest{
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.photosUrl);
    }

    @Test
    public void isPhotoPage(){
        Assert.assertTrue(photosPage.getPageTitle());
    }

    @Test
    public void isPicturesLoaded(){
        Assert.assertTrue(photosPage.loadAlbymPictures());
    }
}
