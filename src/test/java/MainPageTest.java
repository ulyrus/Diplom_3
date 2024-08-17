import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import page.Urls;

@RunWith(Parameterized.class)
public class MainPageTest {

    @Parameterized.Parameters
    public static String[] params() {
        return new String[] { WebDriverFactory.CHROME, WebDriverFactory.YANDEX };
    }

    public MainPageTest(String browser) {
        this.driver = WebDriverFactory.getWebDriver(browser);
    }

    private final WebDriver driver;
    private MainPage page;

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
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
