import io.qameta.allure.junit4.DisplayName;
import org.example.page.AccountAuthorizedPage;
import org.example.page.AuthPage;
import org.example.page.Urls;
import org.junit.Before;
import org.junit.Test;

public class AccountAuthorizedTest extends BaseTest {

    private AuthPage authPage;
    private AccountAuthorizedPage page;

    @Before
    public void setUp() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        page = new AccountAuthorizedPage(driver);
        authPage = new AuthPage(driver);
    }

    @Test
    @DisplayName("переход по клику на «Конструктор»")
    public void clickAtConstructorNavigateToMainTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkClickAtConstructorNavigate();
        waitUrl(Urls.MAIN);
    }

    @Test
    @DisplayName("переход по клику на логотип Stellar Burgers")
    public void clickAtLogoNavigateToMainTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkClickAtLogoNavigate();
        waitUrl(Urls.MAIN);
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    public void clickAtLogoutTest() {
        authPage.loginThroughMainPage(email, password);
        page.navigateToAccount();
        page.checkLogout();
        waitUrl(Urls.LOGIN);
    }
}
