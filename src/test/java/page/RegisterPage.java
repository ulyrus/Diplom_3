package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputName = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By aRegister = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By errorLabel = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("register account, expect success")
    public void registerSuccessfully(String email, String name, String password) {
        waitLoadRegister();
        fillInputName(name);
        fillInputEmail(email);
        fillInputPassword(password);
        clickRegisterButton();
        waitLoadAuth();
    }

    @Step("register account, not filled password field")
    public void tryRegisterNotFilledPassword() {
        waitLoadRegister();
        fillInputName(UUID.randomUUID().toString());
        fillInputEmail(UUID.randomUUID() + "@example.com");
        fillInputPassword("pass");
        clickRegisterButton();
        waitPasswordNotFilledLabel();
    }

    @Step("wait load auth page")
    private void waitLoadAuth() {
        CommonSteps.waitVisibility(driver, aRegister);
    }

    @Step("wait load register page")
    private void waitLoadRegister() {
        CommonSteps.waitVisibility(driver, inputName);
    }

    @Step("fill name")
    private void fillInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("fill email")
    private void fillInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("fill password")
    private void fillInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("click Зарегистрироваться button")
    private void clickRegisterButton() {
        driver.findElement(buttonRegister).click();
    }

    @Step("validate shown password not correct error label")
    private void waitPasswordNotFilledLabel() {
        CommonSteps.waitVisibility(driver, errorLabel);
    }

}
