package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By inputName = By.xpath(".//label[text()='Имя']/following-sibling::input");
    public static final By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input");
    public static final By inputPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    public static final By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By aRegister = By.xpath(".//a[text()='Зарегистрироваться']");
    public static final By errorLabel = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("register account, expect success")
    public void registerSuccessfully(String email, String name, String password) {
        waitLoadRegister();
        fillInputName(name);
        fillInputEmail(email);
        fillInputPassword(password);
        clickRegisterButton();
    }

    @Step("register account, not filled password field")
    public void tryRegisterNotFilledPassword() {
        waitLoadRegister();
        fillInputName(UUID.randomUUID().toString());
        fillInputEmail(UUID.randomUUID() + "@example.com");
        fillInputPassword("pass");
        clickRegisterButton();
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

}
