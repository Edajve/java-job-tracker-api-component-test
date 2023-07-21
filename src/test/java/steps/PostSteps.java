package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.Helpers;
import utils.JobApplication;

import java.util.List;
import java.util.Map;

public class PostSteps {

    private JobApplication application;

    @Given("user signs up using this information")
    public void user_signs_up_using_this_information(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        application = new JobApplication(
                dataList.get(0).get("site"),
                Helpers.getTodayDate(),
                Helpers.getTodayDate(),
                dataList.get(0).get("company_name"),
                dataList.get(0).get("position"),
                dataList.get(0).get("fulltime_Contract"),
                dataList.get(0).get("salary"),
                dataList.get(0).get("company_website"),
                dataList.get(0).get("contact_info"),
                Helpers.getTodayDate(),
                dataList.get(0).get("tech_stack"),
                dataList.get(0).get("round_1"),
                dataList.get(0).get("round_2"),
                dataList.get(0).get("round_3"),
                dataList.get(0).get("final"),
                dataList.get(0).get("notes")
        );
        System.out.println(application);
    }

    @Then("Then user should should receive new application")
    public void then_user_should_should_receive_new_application() {
        Assert.assertTrue(true);
    }
}
