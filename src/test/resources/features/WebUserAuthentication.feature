Feature: Validate user authentication functionality

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @web
  Scenario: Successful login with valid credentials
    When user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    And user enters the location as "booking.city"
    Then verify user is on the home page
    And verify username is displayed in profile section

  @web
  Scenario Outline: Unsuccessful login with invalid credentials
    When user clicks on login button
    Then verify user is on login page
    And user enters the mobile number "<phone.number>" and clicks get otp
    Then verify error message is displayed

    Examples:
      | phone.number |
      | 373738383    |
      | 575884844    |
      | 474888484    |
      | 757488939    |

  @web
  Scenario: Successful logout after login
    When user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    And user enters the location as "booking.city"
    Then verify user is on the home page
    And verify username is displayed in profile section
    When user clicks on logout button
    And user enters the location as "booking.city"
    Then verify user is logged out






