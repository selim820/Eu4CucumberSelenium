
@navigate
  Feature: navigation menu

    Scenario: Navigate to fleet->vehicles page
      Given the user is on the login page
      And the user enters the sales manager information
      When user  should be able to click Fleet
      When user should be able to click Vehicles button
      Then The Title should be Vehicles
    @db
      Scenario:  user should be able to navigate to campaigns page
        Given the user is on the login page
       And the user enters the sales manager information
        When the user navigates to  Marketing,campaigns
        Then user should be able to get to the Campaigns

        Scenario:  user should be able to navigate to Calendar Events menu
          Given the user should be able to login
          When user should be able click Activities button
          When user should be able to click Calendar Events button
          Then user should be able to get to the Calendar Events Page


