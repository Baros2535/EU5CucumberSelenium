package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
       new LoginPage().login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("Dashboard",Driver.get().getTitle());

    }


    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {

        new LoginPage().login(ConfigurationReader.get("sales_manager_username"),ConfigurationReader.get("sales_manager_password"));
 BrowserUtils.waitFor(2);
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        new LoginPage().login(ConfigurationReader.get("store_manager_username"),ConfigurationReader.get("store_manager_password"));

    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
       new LoginPage().login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        the_user_is_on_the_login_page();
    if (userType.toLowerCase().equals("sales manager")){the_user_enters_the_sales_manager_information();}
    else if (userType.toLowerCase().equals("store manager")) { the_user_enters_the_store_manager_information();}
    else if (userType.toLowerCase().equals("driver")){ the_user_enters_the_driver_information();  }
    else{
        System.out.println("invalid 'Usertype'");
    }


    }



}
