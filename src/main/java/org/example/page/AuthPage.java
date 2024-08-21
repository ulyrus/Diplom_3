package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {

    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By buttonLoginInMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By pAccount = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By aLoginInRegister = By.xpath(".//a[text()='Войти']");
    public static final By aLoginInForgotPassword = By.xpath(".//a[text()='Войти']");

    public static final By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input");
    public static final By inputPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    public static final By buttonLogin = By.xpath(".//button[text()='Войти']");
    public static final By buttonOrder = By.xpath(".//button[text()='Оформить заказ']");

    @Step("login through login button in main page")
    public void loginThroughMainPage(String email, String password) {
        driver.get(Urls.MAIN);
        waitAndClick(buttonLoginInMainPage);
        waitLoginButtonVisibility();
        login(email, password);
    }

    @Step("login through login account button")
    public void loginThroughAccountButton(String email, String password) {
        driver.get(Urls.MAIN);
        waitAndClick(pAccount);
        waitLoginButtonVisibility();
        login(email, password);
    }

    @Step("login through login link in register form")
    public void loginThroughRegisterForm(String email, String password) {
        driver.get(Urls.REGISTER);
        waitAndClick(aLoginInRegister);
        waitLoginButtonVisibility();
        login(email, password);
    }

    @Step("login through login link in forgot form")
    public void loginThroughForgotPassword(String email, String password) {
        driver.get(Urls.FORGOT_PASSWORD);
        waitAndClick(aLoginInForgotPassword);
        waitLoginButtonVisibility();
        login(email, password);
    }

    @Step("wait and click to go to login page")
    public void waitAndClick(By selector) {
        CommonSteps.waitVisibility(driver, selector);
        driver.findElement(selector).click();
    }

    @Step("wait login button visibility")
    public void waitLoginButtonVisibility() {
        CommonSteps.waitVisibility(driver, buttonLogin);
    }

    @Step("fill email")
    private void fillEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("fill password")
    private void fillPassword(String pass) {
        driver.findElement(inputPassword).sendKeys(pass);
    }

    @Step("click login button")
    private void clickLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("login")
    private void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickLogin();
    }

}
