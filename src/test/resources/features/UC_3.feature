Feature: Login to Swag Labs

  Scenario Outline: UC-3 Test Login form with valid credentials
    Given the user is on the Swag Labs login page
    When the user enters a valid username "<user>"
    And the user enters a valid password "<password>"
    And the user clicks the Login button
    Then the dashboard title should be "Swag Labs"
    And the current URL should contain "inventory.html"

    Examples:
      | user                    | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |