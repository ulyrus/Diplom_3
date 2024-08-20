import io.qameta.allure.junit4.DisplayName;
import org.example.page.AuthPage;
import org.example.page.CommonSteps;
import org.junit.Before;
import org.junit.Test;

public class AuthTest extends BaseTest {

    private AuthPage page;

    @Before
    public void setUp() {
        page = new AuthPage(driver);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginThroughLoginButtonImMainPageTest() {
        page.loginThroughMainPage(email, password);
        CommonSteps.waitVisibility(driver, AuthPage.buttonOrder);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginThroughAccountButtonTest() {
        page.loginThroughAccountButton(email, password);
        CommonSteps.waitVisibility(driver, AuthPage.buttonOrder);
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginThroughRegisterFormTest() {
        page.loginThroughRegisterForm(email, password);
        CommonSteps.waitVisibility(driver, AuthPage.buttonOrder);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginUsingForgotFormTest() {
        page.loginThroughForgotPassword(email, password);
        CommonSteps.waitVisibility(driver, AuthPage.buttonOrder);
    }

}
