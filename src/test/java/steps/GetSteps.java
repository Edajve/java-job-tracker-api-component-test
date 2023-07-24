package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GetSteps {

    private final String BASE_URL = ConfigReader.getProperty("baseURI");
    private Response response;

    @When("user hits endpoint {string}")
    public void userHitsEndpoint(String endpoint) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get(endpoint);
    }

    @Then("Then user should receive all application")
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
    }

    @Then("Then user should receive an individual application of {string}")
    public void thenUserShouldShouldReceiveAnIndividualApplicationOf(String id) {
        JsonPath jsonPath = response.jsonPath();

        int expectedId = Integer.parseInt(id);
        int actualId = jsonPath.getInt("data[0].id");
        assertEquals(expectedId, actualId);

        String expectedCompanyName = "Randstad technologies";
        String actualCompanyName = jsonPath.getString("data[0].company_name");
        assertEquals(expectedCompanyName, actualCompanyName);

        assertEquals(200, response.getStatusCode());
    }

    @Then("Then user should receive an response with an empty data array")
    public void thenUserShouldShouldReceiveAnResponseWithAnEmptyDataArray() {
        JsonPath jsonPath = response.jsonPath();
        assertNull(jsonPath.get("data[0]"));
        assertEquals(200, response.getStatusCode());
    }

    @When("user hits endpoint {string} with company name of {string}")
    public void userHitsEndpointWithCompanyNameOfOf(String endpoint, String companyName) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .queryParam("company_name", companyName);
        response = request.get(endpoint);
    }

    @Then("Then user should receive all applications with the company name of {string}")
    public void thenUserShouldReceiveAllApplicationsWithTheCompanyNameOf(String expectedCompanyName) {
        List<Map<String, Object>> dataList = response.jsonPath().getList("data");

        for (Map<String, Object> stringObjectMap : dataList) {
            if (stringObjectMap == null) continue;
            Assert.assertEquals(expectedCompanyName, stringObjectMap.get("company_name"));
        }

        assertEquals(200, response.getStatusCode());
    }

    @When("user hits endpoint {string} with and query {string}")
    public void userHitsEndpointWithAndQuery(String endpoint, String columnToAscendBy) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .queryParam("column", columnToAscendBy);
        response = request.get(endpoint);
    }

    @Then("Then user should receive an response with all applications ascending by salary")
    public void thenUserShouldShouldReceiveAnResponseWithAllApplicationsAscendingBySalary() {
        List<Map<String, Object>> dataList = response.jsonPath().getList("data");
        List<String> listOfSalaries = new ArrayList<>();

        for (Map<String, Object> responseBody : dataList) {
            if (responseBody.get("salary") == null) continue;
            listOfSalaries.add(responseBody.get("salary").toString());
        }

        boolean[] isSalaryAscending = new boolean[1];

        for (int i = 0; i < listOfSalaries.size(); i++) {
            if (listOfSalaries.size() - 1 == i) continue;
            if (Integer.parseInt(listOfSalaries.get(i)) <= Integer.parseInt(listOfSalaries.get(i + 1))) {
                isSalaryAscending[0] = true;
            } else {
                isSalaryAscending[0] = false;
                break;
            }
        }

        assertTrue(isSalaryAscending[0]);
        assertEquals(200, response.getStatusCode());
    }
}