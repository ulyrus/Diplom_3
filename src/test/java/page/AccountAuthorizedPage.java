package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountAuthorizedPage {

    private final WebDriver driver;

    public AccountAuthorizedPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By constructor = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By logout = By.xpath(".//button[text()='Выход']");
    private final By login = By.xpath(".//button[text()='Войти']");

    @Step("click at Личный Кабинет to navigate")
    public void navigateToAccount() {
        waitLoad(pAccount);
        click(pAccount);
    }

    @Step("click at Конструктор to navigate")
    public void checkClickAtConstructorNavigate() {
        waitLoad(constructor);
        click(constructor);
        waitUrlChangeToMain();
    }

    @Step("click at logo to navigate")
    public void checkClickAtLogoNavigate() {
        waitLoad(logo);
        click(logo);
        waitUrlChangeToMain();
    }

    @Step("logout")
    public void checkLogout() {
        waitLoad(logout);
        click(logout);
        waitLoad(login);
        waitUrlChangeToLogin();
    }

    @Step("wait load")
    public void waitLoad(By by) {
        CommonSteps.waitVisibility(driver, by);
    }

    @Step("click at navigating element")
    public void click(By by) {
        driver.findElement(by).click();
    }

    @Step("wait url change to main")
    public void waitUrlChangeToMain() {
        CommonSteps.waitUrl(driver, Urls.MAIN);
    }

    @Step("wait url change to login")
    public void waitUrlChangeToLogin() {
        CommonSteps.waitUrl(driver, Urls.LOGIN);
    }
}
