package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
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

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {
        new ContactsPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        new ContactsPage().getContactEmail(email).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        //get information from UI
        ContactInfoPage contactInfoPage=new ContactInfoPage();
        BrowserUtils.waitFor(2);
        String actualFullName = contactInfoPage.fullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

BrowserUtils.waitFor(3);
        // get information from database

      String query="select concat(o_c.first_name,' ',o_c.last_name)  as Full_Name,e.email,p.phone from orocrm_contact o_c \n" +
              "join orocrm_contact_email e on o_c.id=e.owner_id \n" +
              "join orocrm_contact_phone p on o_c.id=p.owner_id\n" +
              "where e.email='mbrackstone9@example.com'";
        Map<String, Object> expectedData = DBUtils.getRowMap(query);



        //compare
        String expectedFullName= (String) expectedData.get("Full_Name");
        String expectedPhone = (String) expectedData.get("phone");
        String expectedEmail= (String) expectedData.get("email");

        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedPhone,actualPhone);
        Assert.assertEquals(expectedEmail,actualEmail);


    }

}
