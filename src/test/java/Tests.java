import API.SetRespons;

import Models.Constants;
import Steps.Stepsssss;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})
public class Tests {
    SetRespons Respons = new SetRespons();
    Stepsssss step = new Stepsssss();
    Constants constants=new Constants();


    @BeforeClass
    @Epic("BaseURI")
    public void callAPI() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test(priority = 0)
    @Description(" წარმატებული ტესტი ")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://classroom.google.com/c/MzUzMjE2MTQ5MDMw/a/NDAyODg5MDMxNTA4/details")


    public void succsessful() {
        Response response = Respons.responsWithSuccsesParams();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(constants.getSuccsesID(), step.deserialisationWithSuccsesParam().id);
        Assert.assertEquals(constants.getSuccsesToken(), step.deserialisationWithSuccsesParam().token);

        System.out.println(step.deserialisationWithSuccsesParam().id);
        System.out.println(step.deserialisationWithSuccsesParam().token);
    }


    @Test(priority = 1)
    @Description("წარმუატებელი ტესტი")
    @Story("Story")
    public void badRequest() {
        Response response = Respons.responsWithBadParams();

        Assert.assertEquals(400, response.statusCode());
        Assert.assertEquals(constants.getBadErrorMessage(), step.deserialisationWithBadParam().error);

        System.out.println(step.deserialisationWithBadParam().error);
    }


    @Test(priority = 2)
    @Feature("Feature რამდენიმე პარამეტრით")
    @Description("რამდენიმე პარამეტრით")
    public void severalParams() {

        Response response = Respons.responsWithSeveralParams();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertNotNull(step.deserialisationWithSeveralParams().createdAt);
        Assert.assertNotNull(step.deserialisationWithSeveralParams().id);
        Assert.assertEquals(constants.getJob(), step.deserialisationWithSeveralParams().job);
        Assert.assertEquals(constants.getName(), step.deserialisationWithSeveralParams().name);

        System.out.println("result:  " + step.deserialisationWithSeveralParams().createdAt);
        System.out.println("result:  " + step.deserialisationWithSeveralParams().id);
        System.out.println("result:  " + step.deserialisationWithSeveralParams().job);
        System.out.println("result:  " + step.deserialisationWithSeveralParams().name);


    }
}
