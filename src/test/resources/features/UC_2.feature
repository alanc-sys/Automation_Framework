Feature: Login to Swag Labs

  Scenario: UC-2 Test Login form with credentials by passing Username
    Given the user is on the Swag Labs login page
    When the user enters any username "standard_user"
    And the user enters any password "secret_sauce"
    And the user clears the "Password" input
    And the user clicks the Login button
    Then the error message "Epic sadface: Password is required" should be displayed