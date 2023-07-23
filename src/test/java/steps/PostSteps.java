package steps;

import Builders.ApplicationBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;
import utils.Helpers;
import utils.JobApplication;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PostSteps {
    private static final String BASE_URL = ConfigReader.getProperty("baseURI");
    private static Response response;
    private static String jsonString;
    private JobApplication application;

    @Given("user posts an application to endpoint {string}")
    public void user_posts_an_application_to_endpoint(String endpoint, DataTable dataTable) throws IOException {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        String todaysDate = Helpers.getTodayDate();
        ApplicationBuilder applicationBuilder = new ApplicationBuilder();
        JobApplication application = applicationBuilder
                .setid("")
                .setSite(dataList.get(0).get("site"))
                .setDate(todaysDate)
                .setDate_applied_to(todaysDate)
                .setCompany_name(dataList.get(0).get("company_name"))
                .setPosition(dataList.get(0).get("position"))
                .setSalary(dataList.get(0).get("salary"))
                .setCompany_website(dataList.get(0).get("company_website"))
                .setContact_info(dataList.get(0).get("contact_info"))
                .setCall_back_date(todaysDate)
                .setFulltime_contract(Boolean.parseBoolean((dataList.get(0).get("fulltime_contract"))))
                .setTech_stack(dataList.get(0).get("tech_stack"))
                .setRound_1(dataList.get(0).get("round_1"))
                .setRound_2(dataList.get(0).get("round_2"))
                .setRound_3(dataList.get(0).get("round_3"))
                .setFinall(dataList.get(0).get("final"))
                .setNotes(dataList.get(0).get("notes"))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String applicationJson = objectMapper.writeValueAsString(application);

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(applicationJson);

        response = request.post(endpoint);

        jsonString = response.asString();
    }

    @Then("Then user should should receive new application")
    public void then_user_should_should_receive_new_application() {
        JsonPath jsonPath = response.jsonPath();
        String responseMessage = jsonPath.getJsonObject("message");
        String expectedResponseMessage = "Application successfully created";

        //Test Company
        //get the name application that was just created by name and validate the properties



        assertEquals(responseMessage, expectedResponseMessage);
        assertEquals(201, response.getStatusCode());
    }


}