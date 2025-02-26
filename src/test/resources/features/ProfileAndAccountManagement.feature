Feature: Profile and Account Management

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @web
  Scenario: Verify user can successfully edit the email in web
    When user clicks on "Login" button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    And user enters the location as "booking.city"
    Then verify user is on the home page
    When user clicks on view profile button
    Then verify the profile page is displayed
    When user clicks on the edit icon of email section
    And user enters the email address "email.updated.address" and saves it
    Then verify the success message is displayed
    And verify the email box contains the updated mail address "email.updated.address"

  @android
  Scenario: Verify user can successfully edit the email in mobile app
    When user navigates to menu page
    And user clicks on "Login" button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on the home page
    When user navigates to menu page
    And user clicks on view profile button
    Then verify the profile page is displayed
    When user clicks on the edit icon of email section
    And user enters the email address "email.updated.address" and saves it
    Then verify the success message is displayed
    And verify the email box contains the updated mail address "email.updated.address"