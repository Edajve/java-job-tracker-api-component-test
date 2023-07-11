package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        assertEquals(200, response.getStatusCode());
        Assert.assertTrue(true);
    }

    @When("user hits endpoint {string} with id of {string}")
    public void user_hits_endpoint_with_id_of(String endpoint, String applicationID) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint + "/" + applicationID);
        jsonString = response.asString();
    }

    @Then("Then user should should receive an individual application of {string}")
    public void thenUserShouldShouldReceiveAnIndividualApplicationOf(String id) {

        JsonPath jsonPath = response.jsonPath();

        // Validate the "id" field
        int expectedId = Integer.parseInt(id);
        int actualId = jsonPath.getInt("data[0].id");
        assertEquals(expectedId, actualId);

        // Validate the "company_name" field
        String expectedCompanyName = "company_name test 2";
        String actualCompanyName = jsonPath.getString("data[0].company_name");
        assertEquals(expectedCompanyName, actualCompanyName);

        assertEquals(200, response.getStatusCode());
    }

    @Then("Then user should should receive an response with an empty data array")
    public void thenUserShouldShouldReceiveAnResponseWithAnEmptyDataArray() {
        JsonPath jsonPath = response.jsonPath();
        assertNull(jsonPath.get("data[0]"));
        assertEquals(200, response.getStatusCode());
    }

    @When("user hits endpoint {string} with company name of of {string}")
    public void userHitsEndpointWithCompanyNameOfOf(String endpoint, String companyName) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint + "/query?company_name=" + companyName);
        jsonString = response.asString();
    }

    @Then("Then user should receive all applications with the company name of {string}")
    public void thenUserShouldReceiveAllApplicationsWithTheCompanyNameOf(String expectedCompanyName) {
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> dataList = response.jsonPath().getList("data");

        for (Map<String, Object> object : dataList) Assert.assertEquals("company_name test 2", object.get("company_name"));
        assertEquals(200, response.getStatusCode());
    }
}