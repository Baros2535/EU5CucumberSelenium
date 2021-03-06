Feature: Contacts page

  Scenario: Default Page Number in Contacts Page
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates from "Customers" to "Contacts"
    Then default page number should be 1


  Scenario: Verify Create Calendar Events
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates from "Activities" to "Calendar Events"
    Then the title contains "Calendar"


  Scenario: Menu Options Driver
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

  Scenario: Menu Options Sales Manager
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
       When the user logs in using following credentials
      |username|user10|
      |password|UserUser123|
      |firstname|Brenden|
      |lastname|Schneider|
      Then the user should be able to login