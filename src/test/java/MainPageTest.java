import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import page.Urls;

public class MainPageTest {

    private WebDriver driver;
    private MainPage page;

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        driver = Browser.getWebBrowser(Browser.CHROME);
        driver.get(Urls.MAIN);
        page = new MainPage(driver);
    }

    @Test
    public void clickAtAccountNavigateTest() {
        page.checkNavigationWork();
    }

    @Test
    public void clickAtTabBunSelectTabTest() {
        page.clickAtSauceTabShouldSelectTab();
        page.clickAtBunTabShouldSelectTab();
    }

    @Test
    public void clickAtTabSauceSelectTabTest() {
        page.clickAtSauceTabShouldSelectTab();
    }

    @Test
    public void clickAtTabFillSelectTabTest() {
        page.clickAtFillTabShouldSelectTab();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
