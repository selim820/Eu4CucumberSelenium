package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
 //1st version plugin = {"json:target/cucumber.json"},//adding json file
        //2nd version plugin={"json:target/cucumber.json",
        //"html:target/default-html-reports"},
        plugin={"json:target/cucumber.json",
"html:target/default-html-reports",
        "rerun:target/rerun.txt"
},
  features="src/test/resources/features",
  glue="com/vytrack/step_definitions" ,
  dryRun=false,
 // tags = "@wip" this was for navigation menu feature driver
   //     tags="@login"//to run all scenarios for feaute login
//tags="@wip" //this is for LoginWithParameters
        tags="@wip" //this is for Contacts.feature

)

public class CukesRunner {

}
