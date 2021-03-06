Feature: Account types
  @wip
  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates from "Activities" to "Calendar Events"
    Then the title contains "Calendar Events - Activities"
  @wip
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates from "Customers" to "Accounts"
    Then the title contains "Accounts - CustomerS"
  @wip
  Scenario:Store manager user
    Given the user logged in as "store manager"
    When the user navigates from "Customers" to "Contacts"
    Then the title contains "Contacts - Customers"



    Scenario Outline: Login with different accounts <userType>
      Given the user logged in as "<userType>"
      When the user navigates from "<tab>" to "<module>"
      Then the title contains "<title>"


      Examples:
      |userType|tab|module|title|
    |driver| Activities |Calendar Events|Calendar Events - Activities|
    |sales manager| Customers |Accounts| Accounts - Customers|
    |store manager| Customers |Contacts| Contacts - Customers|







    Scenario Outline: Different user types
      Given the user logged in as "<userType>"


      Examples:
      |userType|
      |driver  |
      |store manager  |
      |sales manager  |

