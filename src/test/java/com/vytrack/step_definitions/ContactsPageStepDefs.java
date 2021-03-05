package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashBoardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DbUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ContactsPageStepDefs {
    ContactsPage contactsPage=new ContactsPage();
    ContactInfoPage contactInfoPage=new ContactInfoPage();


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {

        DashBoardPage dashBoardPage=new DashBoardPage();
        dashBoardPage.waitUntilLoaderScreenAppear();
        dashBoardPage.waitUntilLoaderScreenAppear();
        List<String> ActualMenuOptions=new ArrayList<>();
                for(WebElement element :dashBoardPage.menuOptions) {
                    ActualMenuOptions.add(element.getText());


                }


        System.out.println("ActualMenuOptions = " + ActualMenuOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("hello");
        Assert.assertEquals(ActualMenuOptions,menuOptions);
/*
                List<String> actualOptions= BrowserUtils.getElementsText(new DashBoardPage().menuOptions);
                Assert.assertEquals(actualOptions,menuOptions);

 */
    }
    @When("the user clicks clicks the {string} from Contacts")
    public void the_user_clicks_clicks_the_from_Contacts(String email) {
        // Write code here that turns the phrase above into concrete actions


        contactsPage.waitUntilLoaderScreenAppear();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail(email).click();

    }




    @Then("the information should be same with data")
    public void the_information_should_be_same_with_data() {
        // Write code here that turns the phrase above into concrete actions
        contactsPage.waitUntilLoaderScreenDisappear();
        contactInfoPage.waitUntilLoaderScreenDisappear();
        String actualPhone = contactInfoPage.phone.getText();
        String actualEmail=contactInfoPage.email.getText();
        String actualFullname = contactInfoPage.contactFullName.getText();

        System.out.println("actualPhone = " + actualPhone);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("ActualFullname = " + actualFullname);
//we will create connection to db
        //DbUtils.createConnection();//we move this to hooks also
        //we are gettig only one row of result so map
        //query for retrieving firstname,lastname,email.phone

        String query="select concat(a.first_name,' ',a.last_name) as \"full_name\",b.email,c.phone\n" +
                "from orocrm_contact a join orocrm_contact_email b\n" +
                "on a.id=b.owner_id\n" +
                "join orocrm_contact_phone c\n" +
                "on a.id=c.owner_id\n" +
                "where b.email='mbrackstone9@example.com'";
        Map<String,Object> rowMap=DbUtils.getRowMap(query);

        String expectedFullName=(String) rowMap.get("full_name");
        String expectedMail=(String)rowMap.get("email");
        String expectedPhone=(String) rowMap.get("phone");
        System.out.println("ExpectedFullName = " + expectedFullName);
        System.out.println("ExpectedMail = " + expectedMail);
        System.out.println("ExpectedPhone = " + expectedPhone);


        //close connection
        //DbUtils.destroy();//we move this to hook class


        Assert.assertEquals("verfiy that expected and actual  fullname are same",expectedFullName,actualFullname);
        Assert.assertEquals("verfiy that expected and actual  email are same",expectedMail,actualEmail);
        Assert.assertEquals("verfiy that expected and actual  phone are same",expectedPhone,actualPhone);
    }

    @Then("the information for {string} should be same with data")
    public void the_information_for_should_be_same_with_data(String email) {
        contactsPage.waitUntilLoaderScreenDisappear();
        contactInfoPage.waitUntilLoaderScreenDisappear();
        String actualPhone=contactInfoPage.phone.getText();
        String actualEmail=contactInfoPage.email.getText();
        String actualFullname=contactInfoPage.contactFullName.getText();

        String query="select concat(a.first_name,' ',a.last_name) as \"full_name\",b.email,c.phone\n" +
                "from orocrm_contact a join orocrm_contact_email b\n" +
                "on a.id=b.owner_id\n" +
                "join orocrm_contact_phone c\n" +
                "on a.id=c.owner_id\n" +
                "where b.email='"+email+"'";
        Map<String,Object> rowMap=DbUtils.getRowMap(query);

        String expectedFullName=(String)rowMap.get("full_name");
        String expectedMail=(String) rowMap.get("email");
        String expectedPhone=(String) rowMap.get("phone");

        Assert.assertEquals("verfiy that expected and actual  fullname are same",expectedFullName,actualFullname);
        Assert.assertEquals("verfiy that expected and actual  email are same",expectedMail,actualEmail);
        Assert.assertEquals("verfiy that expected and actual  phone are same",expectedPhone,actualPhone);



    }
}
