package steps;

import Builders.ApplicationBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;
import utils.Helpers;
import pojo.JobApplication;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PostSteps {
    private final String BASE_URL = ConfigReader.getProperty("baseURI");
    private Response response;
    private JobApplication globalApplication;

    @Given("the application details are")
    public void theApplicationDetailsAre(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String todaysDate = Helpers.getTodayDate();
        ApplicationBuilder applicationBuilder = new ApplicationBuilder();
        globalApplication = applicationBuilder
                .setid("")
                .setSite(table.get(0).get("site"))
                .setDate(todaysDate)
                .setDate_applied_to(todaysDate)
                .setCompany_name(table.get(0).get("company_name"))
                .setPosition(table.get(0).get("position"))
                .setSalary(table.get(0).get("salary"))
                .setCompany_website(table.get(0).get("company_website"))
                .setContact_info(table.get(0).get("contact_info"))
                .setCall_back_date(todaysDate)
                .setFulltime_contract(Boolean.parseBoolean((table.get(0).get("fulltime_contract"))))
                .setTech_stack(table.get(0).get("tech_stack"))
                .setRound_1(table.get(0).get("round_1"))
                .setRound_2(table.get(0).get("round_2"))
                .setRound_3(table.get(0).get("round_3"))
                .setFinall(table.get(0).get("final"))
                .setNotes(table.get(0).get("notes"))
                .build();
    }

    @Given("user posts an application to endpoint {string}")
    public void user_posts_an_application_to_endpoint(String endpoint) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String applicationJson = objectMapper.writeValueAsString(globalApplication);

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(applicationJson);

        response = request.post(endpoint);
    }

    @Then("user should should receive new application")
    public void then_user_should_should_receive_new_application() {
        JsonPath jsonPath = response.jsonPath();
        String responseMessage = jsonPath.getJsonObject("message");
        String expectedResponseMessage = "Application successfully created";

        assertEquals(responseMessage, expectedResponseMessage);
        assertEquals(201, response.getStatusCode());
    }

    @Given("user post this application that already exists to endpoint {string}")
    public void userPostThisApplicationThatAlreadyExistsToEndpoint(String endPoint) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestAssured.baseURI = BASE_URL;
        String jsonBody = objectMapper.writeValueAsString(globalApplication);
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonBody);

        response = request.post(endPoint);
    }

    @Then("user should receive this error message {string}")
    public void userShouldRecieveThisErrorMessage(String errorMessage) {
        JsonPath jsonPath = response.jsonPath();
        String responseMessage = jsonPath.getJsonObject("message");
        assertEquals(responseMessage, errorMessage);

        //clean up made application
        assertTrue(cleanUpCreatedApplication(globalApplication.getCompany_name()));
    }

    private boolean cleanUpCreatedApplication(String companyName) {
        boolean goodToGo = false;
        //get application that was made previously
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .queryParam("company_name", companyName);
        Response response = request.get("/api/v1/applications/query");

        List<Map<String, Object>> dataList = response.jsonPath().getList("data");

        for (Map<String, Object> stringObjectMap : dataList) {
            if (stringObjectMap == null) {
                goodToGo = true;
                break;
            }

            //delete the application
            RequestSpecification deleteRequest = RestAssured.given();
            deleteRequest.delete("/api/v1/applications/" + stringObjectMap.get("id"));
            goodToGo = true;

        }
        return goodToGo;
    }
}