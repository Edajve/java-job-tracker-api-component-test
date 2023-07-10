package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testSteps {
    @Given("Health check is passing healthy")
    public void health_check_is_passing_healthy() {
        System.out.println("In the Given step");
    }

    @When("user hits endpoint {string}")
    public void userHitsEndpoint(String endpoint) {
    }

    @Then("user should be logged into their account")
    public void user_should_be_logged_into_their_account() {
        System.out.println("In the Then step");
    }
}
