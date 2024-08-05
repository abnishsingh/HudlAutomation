@login
Feature: Login Feature Scenarios

Scenario Outline: Successful Login with Valid Credentials

  Given user is on login page
  When user enters valid "<username>" and "<password>"
  And clicks on login button
  Then user is navigated to the home page

  Examples:
    | username             | password   |
    | aabnishh@gmail.com   | Hudl@123   |

  Scenario Outline: Unsuccessful Login with Invalid Credentials

    Given user is on login page
    When user enters invalid "<username>" and "<password>"
    And clicks on login button
    Then user sees an error message

    Examples:
      | username             | password   |
      | aabnis@gmail.com     | Hudl@123    |
