import io.qameta.allure.junit4.DisplayName;
import org.example.page.CommonSteps;
import org.example.page.RegisterPage;
import org.example.page.Urls;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    private RegisterPage page;

    @Override
    protected void createUser() {}

    @Before
    public void setUp() {
        driver.get(Urls.REGISTER);
        page = new RegisterPage(driver);
        email = null;
        password = null;
    }

    @Test
    @DisplayName("успешная регистрация")
    public void testSuccessRegister() {
        email = UUID.randomUUID() + "@gmail.com";
        password = UUID.randomUUID().toString();
        page.registerSuccessfully(
                email,
                UUID.randomUUID().toString(),
                password
        );
        CommonSteps.waitVisibility(driver, RegisterPage.aRegister);
    }

    @Test
    @DisplayName("ошибка при некорректном пароле")
    public void testRegisterWithNotFilledPasswordField() {
        page.tryRegisterNotFilledPassword();
        CommonSteps.waitVisibility(driver, RegisterPage.errorLabel);
    }
}
