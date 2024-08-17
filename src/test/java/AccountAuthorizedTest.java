import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.AccountAuthorizedPage;
import page.AuthPage;

import java.util.UUID;

@RunWith(Parameterized.class)
public class AccountAuthorizedTest {

    @Parameterized.Parameters
    public static String[] params() {
        return new String[] { WebDriverFactory.CHROME, WebDriverFactory.YANDEX };
    }

    public AccountAuthorizedTest(String browser) {
        this.driver = WebDriverFactory.getWebDriver(browser);
    }

    private final WebDriver driver;
    private AuthPage authPage;
    private AccountAuthorizedPage page;
    private final String email = UUID.randomUUID() + "@example.com";
    private final String password = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        UserSteps.createUser("name", email, password);
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
