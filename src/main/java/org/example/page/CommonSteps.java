package org.example.page;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps {
    @Step("Validate response statusCode")
    public static void validateStatus(Response response, int statusCode) {
        response
                .then()
                .statusCode(statusCode);
    }

    @Step("Validate success field")
    public static void validateSuccess(Response response, boolean success) {
        response.then().body("success", CoreMatchers.is(success));
    }

    @Step("wait element visibility")
    public static void waitVisibility(WebDriver driver, By selector) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @Step("wait url")
    public static void waitUrl(WebDriver driver, String url) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlMatches(url));
    }
}
