Feature: Validate user authentication functionality

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @android
  Scenario: Successful login with valid credentials
    When user navigates to menu page
    And user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on the home page
    When user navigates to menu page
    Then verify username is displayed in profile section

  @android
  Scenario Outline: Unsuccessful login with invalid credentials
    When user navigates to menu page
    And user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "<phone.number>" and clicks get otp
    Then verify error message is displayed

    Examples:
      | phone.number |
      | 373738383    |
      | 575884844    |

  @android
  Scenario: Successful logout after login
    When user navigates to menu page
    And user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    And user enters the otp and clicks submit
    Then verify user is on the home page
    When user navigates to menu page
    Then verify username is displayed in profile section
    When user clicks on logout button
    Then verify user is logged out






