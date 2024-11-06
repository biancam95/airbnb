package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ResultsPage;

public class SearchAndFilterSteps {
    WebDriver driver = new ChromeDriver();
    HomePage homepage = new HomePage(driver);
    ResultsPage resultsPage = new ResultsPage(driver);


    @Given("user is on airbnb homepage")
    public void go_to_homepage() {

        driver.navigate().to("https://www.airbnb.com/");
    }

    @When("user searches for criteria")
    public void search_functionality() {
        homepage.searchFunctionality();
    }


    @Then("applied filters are correct in the results page")
    public void check_applied_filters() {
        resultsPage.checkAppliedFilters();
    }

    @And("displayed properties match the applied filters")
    public void check_applied_filters_details() {
        resultsPage.checkAppliedFiltersDetails();
    }

    @And("user applies advanced filters")
    public void apply_advanced_filters() {
        resultsPage.applyAdvancedFilters();
    }

    @Then("details of first properly match the applied advanced filters")
    public void check_first_property_filters() {
        resultsPage.checkAppliedFiltersFirstProperty();
    }

    @Then("user hovers over the first property and and the color of the pin changes")
    public void hover_over_first_property() {
        resultsPage.hoverOverFirstProperty();
    }
}
