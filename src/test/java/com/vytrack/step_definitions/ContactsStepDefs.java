package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuoptions) {
        Assert.assertEquals(menuoptions, BrowserUtils.getElementsText(new DashboardPage().listOfTab));
    }
    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map <String,String> userInfo) {
        new LoginStepDefs().the_user_logs_in_using_and(userInfo.get("username"),userInfo.get("password"));
        Assert.assertEquals(userInfo.get("firstname")+ " "+ userInfo.get("lastname"),new DashboardPage().userName.getText());
        System.out.println(userInfo);
    }



}
