import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.AuthPage;

import java.util.UUID;

@RunWith(Parameterized.class)
public class AuthTest {

    @Parameterized.Parameters
    public static String[] params() {
        return new String[] { WebDriverFactory.CHROME, WebDriverFactory.YANDEX };
    }

    public AuthTest(String browser) {
        this.driver = WebDriverFactory.getWebDriver(browser);
    }

    private final WebDriver driver;
    private AuthPage page;
    private final String email = UUID.randomUUID() + "@example.com";
    private final String password = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        UserSteps.createUser("name", email, password);
        page = new AuthPage(driver);
    }

    @Test
    public void loginThroughLoginButtonImMainPageTest() {
        page.loginThroughMainPage(email, password);
    }

    @Test
    public void loginThroughAccountButtonTest() {
        page.loginThroughAccountButton(email, password);
    }

    @Test
    public void loginThroughRegisterFormTest() {
        page.loginThroughRegisterForm(email, password);
    }

    @Test
    public void loginUsingForgotFormTest() {
        page.loginThroughForgotPassword(email, password);
    }

    @After
    public void tearDown() {
        UserSteps.deleteUser(email, password);
        driver.quit();
    }
}
