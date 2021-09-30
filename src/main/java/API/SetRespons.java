package API;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SetRespons {

    SetRequest request = new SetRequest();

    @Step("respons With Succses Params")
    public Response responsWithSuccsesParams() {

        Response response = given().
                header("Content-Type", "application/json").
                body(request.requestWithSuccsesParams()).
                post("/register");
        return response;
    }

    @Step("respons With Bad Params")
    public Response responsWithBadParams() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(request.requestWithBadParams())
                .post("/register");
        return response;
    }

    @Step("respons With Several Params")
    public Response responsWithSeveralParams() {
        Response response = given().
                header("Content-Type", "application/json").
                body(request.requestWithSeveralParams()).
                post("/users ");
        return response;
    }


}
