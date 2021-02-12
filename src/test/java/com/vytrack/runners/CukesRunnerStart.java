package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//we are defining path here.
@CucumberOptions(
        features = "src/test/resources/features",
        glue="com/vytrack/step_definitions",
        dryRun=false,
        tags="@store_manager"
        //tags="@driver"

        //tags="@smoke" //this will execute all the scenarios that have @smoke
       // tags="@login" //this will run all scenarios in a feauture.
       // tags="@driver and @vy_123" //this is for new cucumber after 4
       // tags={"@driver","@vy_123"} //this is for old verison "and"
       // tags="@driver or @store_manager" //this will execute scnearios that mathces either of tags
        //tags="@driver , @store_manager" //this is old verison of or and doesnt work with versions after 5
//tags="@login and not @wip" //execute alll the login and exclude @wip
        //tags={"@login","~@wip"},//this is old version for exclude

       // tags="@login and not @wip and not @sales_manager" //exclude more than one conditions
)
public class CukesRunnerStart {


}
