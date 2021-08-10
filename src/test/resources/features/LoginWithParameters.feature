Feature: Login as different users

  Scenario: login as different credentials
    Given the user is on the login page
    When the user logs in using "User10" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"

 Scenario: login as different usertype
   Given the user logged in as "userType"
   Then the user should be able to login
   And the title contains "Dashboard"
