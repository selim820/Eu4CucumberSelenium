package com.vytrack.step_definitions;

import com.vytrack.pages.DashBoardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.security.auth.login.Configuration;
import java.util.Locale;
import java.util.Map;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url= ConfigurationReader.get("url");
     //  WebDriver driver= Driver.get();//we dont use this because it will be local and we cant use it in another methods
        //but we can user it Driver.get() as we are dealing with the same object everywhere

       Driver.get().get(url);

    }




    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        //and now real codes
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);

    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        //we deleted throws
//and now real codes
        BrowserUtils.waitFor(3);
        String actualTitle= Driver.get().getTitle();

        String ExpectedTitle="Dashboard";
        Assert.assertEquals(ExpectedTitle,actualTitle);

    }


    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {

        String username=ConfigurationReader.get("sales_manager_username");
        String password=ConfigurationReader.get("sales_manager_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);




    }


    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
       String username=ConfigurationReader.get("store_manager_username");
       String password=ConfigurationReader.get("store_manager_password");

       LoginPage loginPage=new LoginPage();
       loginPage.login(username,password);


    }


    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);

    }


    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String UserType) {
        // Write code here that turns the phrase above into concrete actions
        String username="no username";
        String password="no password";
        switch(UserType.toLowerCase()) {
            case "driver":
                username=ConfigurationReader.get("driver_username");
                password=ConfigurationReader.get("driver_password");
                break;
            case "sales manager" :
                username=ConfigurationReader.get("sales_manager_username");
                password=ConfigurationReader.get("sales_manager_password");
                break;
            case "store manager" :
                username=ConfigurationReader.get("store_manager_username");
                password=ConfigurationReader.get("store_manager_password");
                break;

        }
        the_user_is_on_the_login_page();
        user_logs_in_using_and(username,password);
        /*
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage =new LoginPage();
        loginPage.login(username,password);

         */



    }


    @When("the user logs in following credentials")
    public void the_user_logs_in_following_credentials(Map<String,String> userInfo) {
        LoginPage loginPage=new LoginPage();

        String username = userInfo.get("username");
        String password=userInfo.get("password");
        String ExpectedFirstname=userInfo.get("firstname");
        String ExpectedLastname=userInfo.get("lastname");
        loginPage.login(username,password);

        DashBoardPage dashBoardPage=new DashBoardPage();
        String actualuserName=dashBoardPage.getUserName();
        String ExpectedUsername=ExpectedFirstname+" "+ExpectedLastname;
        System.out.println("ExpectedUsername = " + ExpectedUsername);
        System.out.println("ExpectedLastname = " + ExpectedLastname);

        Assert.assertEquals(ExpectedUsername,actualuserName);


    }





}
