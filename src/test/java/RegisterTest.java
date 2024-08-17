import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;
import page.Urls;

import java.util.UUID;

public class RegisterTest {

    private WebDriver driver;
    private RegisterPage page;
    private String registeredEmail;
    private String registeredPassword;

    @Before
    public void setUp() {
        RestAssured.baseURI = Api.BASE_URL;
        driver = Browser.getWebBrowser(Browser.CHROME);
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
