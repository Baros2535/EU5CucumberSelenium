Feature:
@wip @db
  Scenario: Vehicle model UI DB Comparison
    Given the user is on the login page
    And the user logged in as "sales manager"
    And the user navigates from "Fleet" to "Vehicles Model"
    And the user clicks the "Mazda" from list
    Then the vehicle model information should be same with database
