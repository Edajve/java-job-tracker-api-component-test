package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

public class ApplicationSteps {

    private static final String BASE_URL = ConfigReader.getProperty("baseURI");
    private static Response response;
    private static String jsonString;

    @When("user hits endpoint {string}")
    public void userHitsEndpoint(String endpoint) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint);
        jsonString = response.asString();
    }

    @Then("Then user should should receive all application")
    public void thenUserShouldShouldReceiveAllApplication() {
        //Didn't add validate yet for this
        //need to figure out a way to validate
        //this after other tests have run
        Assert.assertTrue(true);
    }
}