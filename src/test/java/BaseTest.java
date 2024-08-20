import io.restassured.RestAssured;
import org.example.page.CommonSteps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class BaseTest {

    protected String name = UUID.randomUUID().toString();
    protected String email = UUID.randomUUID() + "@example.com";
    protected String password = UUID.randomUUID().toString();

    protected final WebDriver driver = WebDriverFactory.getWebDriver();

    @Before
    public void baseSetUp() {
        RestAssured.baseURI = Api.BASE_URL;
        createUser();
    }

    @After
    public void baseTearDown() {
        UserSteps.deleteUser(email, password);
        driver.quit();
    }

    protected void createUser() {
        UserSteps.createUser(name, email, password);
    }

    protected void waitUrl(String url) {
        CommonSteps.waitUrl(driver, url);
    }
}
