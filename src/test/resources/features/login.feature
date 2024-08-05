@login
Feature: Login Feature Scenarios

Scenario Outline: Successful Login with Valid Credentials

  Given user is on login page
  When user enters valid "<username>" and "<password>"
  And clicks on login button
  Then user is navigated to the home page

  Examples:
    | username             | password   |
    | test@gmail.com       | test       |

  Scenario Outline: Unsuccessful Login with Invalid Credentials

    Given user is on login page
    When user enters invalid "<username>" and "<password>"
    And clicks on login button
    Then user sees an error message

    Examples:
      | username             | password   |
      | testtt@gmail.com     | test       |
