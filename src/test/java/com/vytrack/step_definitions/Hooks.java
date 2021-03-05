package com.vytrack.step_definitions;


import com.vytrack.utilities.DbUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setUp() { System.out.println("    this comes from before"); }
    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        System.out.println("    this comes from after");
        Driver.closeDriver();
    }



    @Before("@db")
    public void setupDb() {
        System.out.println("\t connecting to database");
        DbUtils.createConnection();
    }
    @After("@db")
    public void closeDb(){
        System.out.println("\t disconnecting to database");
        DbUtils.destroy();

    }
}



