package steps;

import Builders.ApplicationBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
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
import pojo.JobApplication;

import java.lang.reflect.Field;
import java.util.*;

public class PutSteps {

    private final String BASE_URL = ConfigReader.getProperty("baseURI");
    private Response response;
    private final String randomWord = Helpers.generateRandomWord();
    private final int randomNum = new Random().nextInt(10);

    @Given("user hits endpoint {string} trying to update application with id of {string}")
    public void userHitsEndpointTryingToUpdateApplicationWithIdOf(String endpoint, String id) throws JsonProcessingException {
        String todaysDate = Helpers.getTodayDate();
        ApplicationBuilder builder = new ApplicationBuilder();
        ObjectMapper objectMapper = new ObjectMapper();

        //Everytime this test runs, the data that is updating the application is dynamic
        JobApplication application = builder
                .setid("")
                .setSite(randomWord)
                .setDate(todaysDate)
                .setDate_applied_to(todaysDate)
                .setCompany_name(randomWord)
                .setPosition(randomWord)
                .setSalary(String.valueOf(randomNum))
                .setCompany_website(randomWord)
                .setContact_info(randomWord)
                .setCall_back_date(todaysDate)
                .setFulltime_contract(true)
                .setTech_stack(randomWord)
                .setRound_1(randomWord)
                .setRound_2(randomWord)
                .setRound_3(randomWord)
                .setFinall(randomWord)
                .setNotes(randomWord)
                .build();

        String updatedApplicationBody = objectMapper.writeValueAsString(application);

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(updatedApplicationBody);

        response = request.put(endpoint + id);
    }

    @Then("application with id {string} should be updated")
    public void applicationWithIdShouldBeUpdated(String id) throws Exception {
        Assert.assertTrue(!applicationWithIdShouldBeUpdated(id, randomNum, randomWord).contains(false));
    }

    public ArrayList<Boolean> applicationWithIdShouldBeUpdated(String id, int randomNum, String randomWord) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        // Grab the updated application
        Response updatedResponse = request.get("/api/v1/applications/" + id);
        Map<String, Object> responseObject = updatedResponse.jsonPath().getMap("data[0]");
        JobApplication deserializedApplication = objectMapper.convertValue(responseObject, JobApplication.class);
        return validateDeserializedApplication(deserializedApplication, randomNum, randomWord);
    }

    public ArrayList<Boolean> validateDeserializedApplication(JobApplication deserializedApplication, int randomNum, String randomWord) throws Exception {
        Class<JobApplication> jobApplication = JobApplication.class;
        Field[] fields = jobApplication.getFields();
        ArrayList<Boolean> areAllFieldsCorrect = new ArrayList<>();
        //iterate through response and verify all fields are correct
        for (Field field : fields) {
            String property = field.getName();
            Object value = field.get(deserializedApplication);

            if (property.contains("id")) areAllFieldsCorrect.add(value.toString().contains(String.valueOf(0)));
            else if (property.contains("date"))
                areAllFieldsCorrect.add(value.toString().contains(Helpers.getTodayDate()));
            else if (property.contains("date_applied_to"))
                areAllFieldsCorrect.add(value.toString().contains(Helpers.getTodayDate()));
            else if (property.contains("salary"))
                areAllFieldsCorrect.add(value.toString().contains(String.valueOf(randomNum)));
            else if (property.contains("fulltime_contract")) areAllFieldsCorrect.add(value.toString().contains("null"));
            else areAllFieldsCorrect.add(value.toString().contains(randomWord));
        }
        return areAllFieldsCorrect;
    }
}
