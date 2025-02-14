Feature: Validate user authentication functionality

  Background:
    Given user opens website or application
    When user enters the location as "booking.city"
    Then verify user is on the home page

  @web @android
  Scenario: Successful login with valid credentials
    When user navigates to login page
    And user does login with phone number "phone.number"
    Then verify user is on home page
    And verify username is displayed in profile section

  @web @android
  Scenario Outline: Unsuccessful login with invalid credentials
    When user navigates to login page
    And user does login with phone number "<phone.number>"
    Then verify error message is displayed

    Examples:
      | phone.number |
      | 3737383833   |
      | 5758848448   |
      | 474888484    |
      | 757488939    |

  @web @android
  Scenario: Successful logout after login
    When user navigates to login page
    And user does login with phone number "phone.number"
    Then verify user is on home page
    And verify username is displayed in profile section
    When user clicks on logout btn
    Then verify user is logged out






