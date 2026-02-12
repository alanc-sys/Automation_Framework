Feature: Login to Swag Labs

  Scenario: UC-1 Test Login form with empty credential
    Given the user is on the Swag Labs login page
    When the user enters any credentials
    And the user clears the input fields
    And the user clicks the Login button
    Then the error message "Epic sadface: Username is required" should be displayed
