package org.example.page;

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

    public static final String BUN = "Булки";
    public static final String SAUCE = "Соусы";
    public static final String FILL = "Начинки";

    public static final By account = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By tabBun = By.xpath(String.format(".//span[text()='%s']", BUN));
    public static final By tabSauce = By.xpath(String.format(".//span[text()='%s']", SAUCE));
    public static final By tabFill = By.xpath(String.format(".//span[text()='%s']", FILL));
    public static final By selectedTab = By.className("tab_tab_type_current__2BEPc");

    @Step("navigation from account to long")
    public void checkNavigationWork() {
        driver.get(Urls.MAIN);
        waitLoad(account);
        clickButtonAccount();
    }

    @Step("select tab " + BUN)
    public void clickAtBunTabShouldSelectTab() {
        waitLoad(tabBun);
        clickAtBunTab();
    }

    @Step("select tab " + SAUCE)
    public void clickAtSauceTabShouldSelectTab() {
        driver.get(Urls.MAIN);
        waitLoad(tabSauce);
        clickAtSauceTab();
    }

    @Step("select tab " + FILL)
    public void clickAtFillTabShouldSelectTab() {
        driver.get(Urls.MAIN);
        waitLoad(tabFill);
        clickAtFillTab();
    }

    @Step("wait load")
    private void waitLoad(By by) {
        CommonSteps.waitVisibility(driver, by);
    }

    @Step("click Личный кабинет")
    private void clickButtonAccount() {
        driver.findElement(account).click();
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

    @Step("wait tab selection")
    public void waitTabSelection(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBe(selectedTab, text));
    }
}
