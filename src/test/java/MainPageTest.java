import io.qameta.allure.junit4.DisplayName;
import org.example.page.MainPage;
import org.example.page.Urls;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest extends BaseTest {

    private MainPage page;

    @Before
    public void setUp() {
        driver.get(Urls.MAIN);
        page = new MainPage(driver);
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    public void clickAtAccountNavigateTest() {
        page.checkNavigationWork();
        waitUrl(Urls.LOGIN);
    }

    @Test
    @DisplayName("переходы к разделу Булки")
    public void clickAtTabBunSelectTabTest() {
        page.clickAtSauceTabShouldSelectTab();
        page.clickAtBunTabShouldSelectTab();
        page.waitTabSelection(MainPage.BUN);
    }

    @Test
    @DisplayName("переходы к разделу Соусы")
    public void clickAtTabSauceSelectTabTest() {
        page.clickAtSauceTabShouldSelectTab();
        page.waitTabSelection(MainPage.SAUCE);
    }

    @Test
    @DisplayName("переходы к разделу Начинки")
    public void clickAtTabFillSelectTabTest() {
        page.clickAtFillTabShouldSelectTab();
        page.waitTabSelection(MainPage.FILL);
    }

}
