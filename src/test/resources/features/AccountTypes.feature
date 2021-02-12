Feature: Account types
@wip
  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates to  "Activities" "Calendar Events"
    Then the Page Title contains "Calendar Events"
@wip
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates to  "Customers" "Accounts"
    #Then the Page Title contains "Accounts - Customers"
  #to delibrately make scenario fail
  Then the Page Title contains "Accounts-CustomerS"
@wip
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates to  "Customers" "Contacts"
    Then the Page Title contains "Contacts - Customers"


  Scenario Outline: Different user types with tab-module-title
    Given the user logged in as "<userTypes>"
    When the user navigates to  "<tab>" "<module>"
    Then the Page Title contains "<title>"
    Examples:
      | userTypes     | tab        | module          | title              |
      | driver        | Activities | Calendar Events | Calendar Events    |
      | sales manager | Customers  | Calendar Events | Accounts-Customers |
      | store manager | Customers  | Contacts        | Contacts-Customers |

  #  Scenario: Driver user
   #   Given the user logged in as "driver"


   # Scenario: Sales manager user
    #  Given the user logged in as "sales manager"


    #Scenario: Store manager user
     # Given the user logged in as "store manager"


  Scenario Outline: Different user types
    Given the user logged in as "<userTypes>"
    Examples:
      | userTypes     |
      | driver        |
      | admin         |
      | store manager |
      | sales manager |


    Scenario Outline: Different user types with more parameters <userType>
      Given the user logged in as "<userType>"
      When the user navigates to  "<tab>" "<module>"
      Then the Page Title contains "<title>"

      Examples:
        | userType      | tab        | module          | title                                                              |
        | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
        | driver        | Customers  | Accounts        | Accounts - Customers                                               |
        | driver        | Customers  | Contacts        | Contacts - Customers                                               |
        | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
        | driver        | System     | Jobs            | Jobs - System                                                      |
        | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
        | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
        | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
        | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
        | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
        | sales manager | System     | Jobs            | All - Jobs - System                                                |
        | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
        | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
        | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
        | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
        | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
        | store manager | System     | Jobs            | All - Jobs - System                                                |
        | store manager | System     | Menus           | All - Menus - System                                               |



    #now checout the pipe contact page to see combined version of ddt and pipeline in contact page

      