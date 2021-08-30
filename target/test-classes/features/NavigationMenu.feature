@Navigation_Menu
Feature:Navigation From Menu to Menu
  @Navigating_Vehicles @smoke
  Scenario: Navigate from Fleet Menu to Vehicles Menu
    Given the user is on the login page
    And   the user enters the sales manager information
    When the user navigates to Vehicles
    Then the user should be able to see the Vehicles as a title

    @Navigating_Campaigns @db
  Scenario: Navigate from Marketing Menu to Campaigns Menu
      Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Campaigns
    Then the user should be able to see the Campaigns as a title
@Navigating_Calendar_Events
  Scenario: Navigate from Activities Menu to Calendar Events Menu
  Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Calendar Events
    Then the user should be able to see the Calendars as a title