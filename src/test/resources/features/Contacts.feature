Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to  "Customers" "Contacts"
    Then Page number should be 1


  Scenario: Verify Create Calendar Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to  "Activities" "Calendar Events"
    Then the Page Title contains "Calendar"
  #to make scenario fail make Calendars
    Then the Page Title contains "Calendars"

  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customners |
      | Activities |
      | System     |


  Scenario: Menu Options as sales manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


  Scenario: login as a given user
    Given the user is on the login page
    When the user logs in following credentials
      | username  | user10      |
      | password  | UserUser123 |
      | firstname | Brenden     |
      | lastname  | Schneider   |
    Then the user should be able to login


  Scenario Outline:  login as a givern user
    Given the user is on the login page

    When the user logs in following credentials

      | username  | <user>      |
      | password  | UserUser123 |
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    Then the user should be able to login
    Examples:
      | user           | firstname | lastname  |
    #  | user10         | Brenden   | Schneider | youcan comment one line
      | storemanager85 | Stephant  | Haley     |



