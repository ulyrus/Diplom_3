import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.AccountAuthorizedPage;
import page.AuthPage;

import java.util.UUID;

public class AccountAuthorizedTest {

    private WebDriver driver;
    private AuthPage authPage;
    private AccountAuthorizedPage page;
    private final String email = UUID.randomUUID() + "@example.com";
    private final String password = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        UserSteps.createUser("name", email, password);
        driver = Browser.getWebBrowser(Browser.CHROME);
        driver.get("https://stellarburgers.nomoreparties.site/");
        page = new AccountAuthorizedPage(driver);
        authPage = new AuthPage(driver);
    }

    @Test
    public void clickAtConstructorNavigateToMainTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkClickAtConstructorNavigate();
    }

    @Test
    public void clickAtLogoNavigateToMainTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkClickAtLogoNavigate();
    }

    @Test
    public void clickAtLogoutTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkLogout();
    }

    @After
    public void tearDown() {
        UserSteps.deleteUser(email, password);
        driver.quit();
    }
}
