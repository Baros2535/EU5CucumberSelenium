package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class NavigationMenuStepDefs {

    @When("the user navigates to Vehicles")
    public void the_user_navigates_to_Vehicles() {
        System.out.println("user navigates to Vehicles");
    }

    @Then("the user should be able to see the Vehicles as a title")
    public void the_user_should_be_able_to_see_the_Vehicles_as_a_title() {
        System.out.println("user can see the Vehicles title");
    }

    @When("the user navigates to Campaigns")
    public void the_user_navigates_to_Campaigns() {
        System.out.println("user navigates to Campaigns");
    }

    @Then("the user should be able to see the Campaigns as a title")
    public void the_user_should_be_able_to_see_the_Campaigns_as_a_title() {
        System.out.println("user can see the Campaigns title");
    }

    @When("the user navigates to Calendar Events")
    public void the_user_navigates_to_Calendar_Events() {
        System.out.println("user navigates to Calendar Events");
    }

    @Then("the user should be able to see the Calendars as a title")
    public void the_user_should_be_able_to_see_the_Calendars_as_a_title() {
        System.out.println("user can see the Calendars title");
    }

    @When("the user navigates from {string} to {string}")
    public void the_user_navigates_from_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);

    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNumber) {
        new ContactsPage().waitUntilLoaderScreenDisappear();
        String actualPageNumber = new ContactsPage().pageNumber.getAttribute("value");
        Assert.assertEquals(expectedPageNumber+"",actualPageNumber);


    }





}
