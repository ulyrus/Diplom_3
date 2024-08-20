import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.page.CommonSteps;

import static io.restassured.RestAssured.given;

public class UserSteps {

    @Step("create user")
    public static void createUser(String name, String email, String password) {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"name\":\"%s\",\"password\":\"%s\"}", email, name, password))
                .post(Api.AUTH_REGISTER);
        CommonSteps.validateStatus(response, 200);
        CommonSteps.validateSuccess(response, true);
    }

    @Step("get user accessToken")
    public static String getUserAccessToken(String email, String password) {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password))
                .post(Api.AUTH_LOGIN);
        return response.body().path("accessToken");
    }

    @Step("delete user")
    public static void deleteUser(String email, String password) {
        String accessToken = getUserAccessToken(email, password);
        if (accessToken == null) return;
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .delete(Api.AUTH_USER);
    }
}
