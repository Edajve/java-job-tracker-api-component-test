package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

public class GetSteps {

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

    @When("user hits endpoint {string} with id of {string}")
    public void user_hits_endpoint_with_id_of(String endpoint, String applicationID) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint + "/" + applicationID);
        jsonString = response.asString();
    }

    @Then("Then user should should receive an individual application")
    public void then_user_should_should_receive_an_individual_application() {
        String applicationWithIdOfOne =
                "{\"success\":true,\"data\":[{\"id\":1,\"site\":\"set new new\"," +
                        "\"date\":\"2023-09-02T05:00:00.000Z\",\"date_applied_to\":\"2023-09-02T05:00:00.000Z" +
                        "\",\"company_name\":\"adfasfds\",\"position\":\"newly set value\"," +
                        "\"fulltime_contract\":true,\"salary\":1212121,\"company_website\"" +
                        ":\"newly set value\",\"contact_info\":\"newly set value\",\"call_bac" +
                        "k_date\":\"newly set value\",\"tech_stack\":\"newly set value\"," +
                        "\"round_1\":\"false\",\"round_2\":\"newly set value\",\"round_3\":" +
                        "\"newly set value\",\"final\":\"newly set value\",\"notes\":\"newly set value\"}]}";

        Assert.assertEquals("This is not matching", applicationWithIdOfOne, jsonString);
    }

    @Then("Then user should should receive an response with an empty data array")
    public void thenUserShouldShouldReceiveAnResponseWithAnEmptyDataArray() {
        String unavailableData = "{\"success\":true,\"data\":[]}";
        Assert.assertEquals("This is not matching", unavailableData, jsonString);
    }
}