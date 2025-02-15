Feature: Validate user authentication functionality

  Background:
    Given user opens website or application
    When user enters the location as "booking.city"
    Then verify user is on the home page

  @android
  Scenario: Successful login with valid credentials
    When user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on the home page
    And verify username is displayed in profile section

  @android
  Scenario Outline: Unsuccessful login with invalid credentials
    When user clicks on login button
    Then verify user is on login page
    And user enters the mobile number "<phone.number>" and clicks get otp
    Then verify error message is displayed

    Examples:
      | phone.number |
      | 3737383833   |
      | 5758848448   |
      | 474888484    |
      | 757488939    |

  @android
  Scenario: Successful logout after login
    When user clicks on login button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on the home page
    And verify username is displayed in profile section
    When user clicks on logout btn
    Then verify user is logged out






