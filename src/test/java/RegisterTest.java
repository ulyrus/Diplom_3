import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;
import page.Urls;

import java.util.UUID;

@RunWith(Parameterized.class)
public class RegisterTest {

    @Parameterized.Parameters
    public static String[] params() {
        return new String[] { WebDriverFactory.CHROME, WebDriverFactory.YANDEX };
    }

    public RegisterTest(String browser) {
        this.driver = WebDriverFactory.getWebDriver(browser);
    }

    private final WebDriver driver;
    private RegisterPage page;
    private String registeredEmail;
    private String registeredPassword;

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        driver.get(Urls.REGISTER);
        page = new RegisterPage(driver);
    }

    @Test
    public void testSuccessRegister() {
        registeredEmail = UUID.randomUUID() + "@example.com";
        registeredPassword = UUID.randomUUID().toString();
        page.registerSuccessfully(
                registeredEmail,
                UUID.randomUUID().toString(),
                registeredPassword
        );
    }

    @Test
    public void testRegisterWithNotFilledPasswordField() {
        page.tryRegisterNotFilledPassword();
    }

    @After
    public void tearDown() {
        if (registeredEmail != null && registeredPassword != null) {
            UserSteps.deleteUser(registeredEmail, registeredPassword);
        }
        driver.quit();
    }
}
