package com.vytrack.step_definitions;

import com.vytrack.pages.DashBoardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContactsPageStepDefs {


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
}
