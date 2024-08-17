package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String BUN = "Булки";
    private final String SAUCE = "Соусы";
    private final String FILL = "Начинки";
    private final By account = By.xpath(".//p[text()='Личный Кабинет']");
    private final By tabBun = By.xpath(String.format(".//span[text()='%s']", BUN));
    private final By tabSauce = By.xpath(String.format(".//span[text()='%s']", SAUCE));
    private final By tabFill = By.xpath(String.format(".//span[text()='%s']", FILL));
    private final By selectedTab = By.className("tab_tab_type_current__2BEPc");

    @Step("navigation from account to long")
    public void checkNavigationWork() {
        driver.get(Urls.MAIN);
        waitLoad(account);
        clickButtonAccount();
        waitUrlChangedToLogin();
    }

    @Step("select tab " + BUN)
    public void clickAtBunTabShouldSelectTab() {
        waitLoad(tabBun);
        clickAtBunTab();
        validateSelectedTab(BUN);
    }

    @Step("select tab " + SAUCE)
    public void clickAtSauceTabShouldSelectTab() {
        driver.get(Urls.MAIN);
        waitLoad(tabSauce);
        clickAtSauceTab();
        validateSelectedTab(SAUCE);
    }

    @Step("select tab " + FILL)
    public void clickAtFillTabShouldSelectTab() {
        driver.get(Urls.MAIN);
        waitLoad(tabFill);
        clickAtFillTab();
        validateSelectedTab(FILL);
    }

    @Step("wait load")
    private void waitLoad(By by) {
        CommonSteps.waitVisibility(driver, by);
    }

    @Step("click Личный кабинет")
    private void clickButtonAccount() {
        driver.findElement(account).click();
    }

    @Step("assert url changed")
    private void waitUrlChangedToLogin() {
        CommonSteps.waitUrl(driver, Urls.LOGIN);
    }

    @Step("click " + BUN)
    private void clickAtBunTab() {
        driver.findElement(tabBun).click();
    }

    @Step("click " + SAUCE)
    private void clickAtSauceTab() {
        driver.findElement(tabSauce).click();
    }

    @Step("click " + FILL)
    private void clickAtFillTab() {
        driver.findElement(tabFill).click();
    }

    @Step("validate stand selected")
    public void validateSelectedTab(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBe(selectedTab, text));
    }
}
