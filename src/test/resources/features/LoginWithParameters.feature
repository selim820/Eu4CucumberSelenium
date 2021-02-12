
Feature:  Login as different users

  Scenario: login as driver user
    Given the user is on the login page
    When user logs in using "User10" and "UserUser123"
    Then the user should be able to login
    And the Page Title contains "Dashboard"


    #homework

  Scenario: login as a driver
    Given the user logged in as "sales_manager"
    Then the user should be able to login



