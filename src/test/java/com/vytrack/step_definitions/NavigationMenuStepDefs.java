package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashBoardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {






    @When("user  should be able to click Fleet")
    public void user_should_be_able_to_click_Fleet() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user  should be able to click Fleet");
    }
    @When("user should be able to click Vehicles button")
    public void user_should_be_able_to_click_Vehicles_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to click Vehicles button");
    }



    @Then("The Title should be Vehicles")
    public void the_Title_should_be_Vehicles() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("The Title should be Vehicles");
    }



    @When("user should be able to click Marketing button")
    public void user_should_be_able_to_click_Marketing_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to click Marketing button");
    }
    @When("user should be able to click on Campaigns button")
    public void user_should_be_able_to_click_on_Campaigns_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to click on Campaigns button");
    }
    @Then("user should be able to get to the Campaigns")
    public void user_should_be_able_to_get_to_the_Campaigns() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to get to the Campaigns");
    }


    @When("user should be able click Activities button")
    public void user_should_be_able_click_Activities_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able click Activities button");
    }
    @When("user should be able to click Calendar Events button")
    public void user_should_be_able_to_click_Calendar_Events_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to click Calendar Events button");
    }
    @Then("user should be able to get to the Calendar Events Page")
    public void user_should_be_able_to_get_to_the_Calendar_Events_Page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user should be able to get to the Calendar Events Page");
    }


    @When("the user navigates to  Marketing,campaigns")
    public void the_user_navigates_to_Marketing_campaigns() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the user navigates to  Marketing,campaigns");
    }

    @When("the user navigates to  {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        // Write code here that turns the phrase above into concrete actions
        new DashBoardPage().waitUntilLoaderScreenAppear();
        new DashBoardPage().waitUntilLoaderScreenDisappear();
       new DashBoardPage().navigateToModule(tab,module);
    }

    @Then("Page number should be {int}")
    public void page_number_should_be(Integer expectedPageNumber) {
        // Write code here that turns the phrase above into concrete actions
        ContactsPage contactsPage=new ContactsPage();

        contactsPage.waitUntilLoaderScreenAppear();
        contactsPage.waitUntilLoaderScreenDisappear();
        //contactsPage.pageNumber.getText() returns "" string
        Integer actualPageNumber=Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNumber,actualPageNumber);
    }


    @Then("the Page Title contains {string}")
    public void the_Page_Title_contains(String ExpectedTitle) {
        BrowserUtils.waitFor(2);

        System.out.println(ExpectedTitle);
        Assert.assertTrue(Driver.get().getTitle().contains(ExpectedTitle));

    }


}
